package priv.lst.util;

import javassist.bytecode.ByteArray;
import lombok.Data;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;
import org.apache.commons.collections4.CollectionUtils;
import org.jboss.netty.buffer.ChannelBuffer;
import priv.lst.arch.test.MillisecondClock;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.*;
import java.util.zip.InflaterInputStream;

public class NkvUtil {

    private static LZ4Compressor fastCompressor = null;
    private static LZ4FastDecompressor decompressor = null;
    public static final int FAST_COM_CODE = 0xE5A7C09B;
    public static final int SLOTH_DEFAULT_COMPRESS_THRESHOLD = 8192;

    static {
        LZ4Factory factory = LZ4Factory.fastestInstance();
        fastCompressor = factory.fastCompressor();
        decompressor = factory.fastDecompressor();
    }

//    public static int getMaxCompressedValue(DataEntry value){
//        if(value.getSize() < SLOTH_DEFAULT_COMPRESS_THRESHOLD){
//            return value.getSize();
//        }
//        LZ4Compressor compressor = fastCompressor;
//        return compressor.maxCompressedLength(value.getData().length);
//    }

    public static CompressedValue compress(byte[] value) {
        CompressedValue res = new CompressedValue();
        LZ4Compressor compressor = fastCompressor;
        int maxLength = compressor.maxCompressedLength(value.length);
        byte[] compressed = new byte[maxLength];
        int compressedLength = compressor.compress(value, 0, value.length, compressed, 0, maxLength);
        res.value = compressed;
        res.length = compressedLength;
        res.olength = value.length;
        return res;
    }

    public static byte[] decompress(byte[] value) {
        if (value == null || value.length <= 8) {
            return null;
        }
        int code = convertInt(value, 0);
        if (code != FAST_COM_CODE){
            return null;
        }
        int olength = convertInt(value, 4);
        byte[] restored = new byte[olength];
        int dlength = decompressor.decompress(value, 8, restored, 0, olength);
        if (dlength != value.length - 8) {
            return null;
        }
        return restored;
    }

    private static int convertInt(byte[] src, int start) {
        return (src[start] & 0xFF) << 24 | (src[start + 1] & 0xFF) << 16 |
            (src[start + 2] & 0xFF) << 8 | src[start + 3] & 0xFF;
    }

    public static SocketAddress cast2SocketAddress(String addr) {
        String[] str = addr.split(":");
        if (str.length != 2) {
            throw new IllegalArgumentException();
        }
        return new InetSocketAddress(str[0], Integer.valueOf(str[1]));
    }

    public static SocketAddress cast2SocketAddress(long id) {
        StringBuffer host = new StringBuffer(30);

        host.append((id & 0xff)).append('.');
        host.append(((id >> 8) & 0xff)).append('.');
        host.append(((id >> 16) & 0xff)).append('.');
        host.append(((id >> 24) & 0xff));

        int port = (int)((id >> 32) & 0xffff);

        return new InetSocketAddress(host.toString(), port);
    }

    public static String decodeString(ChannelBuffer in) {
        int len = in.readInt();
        if (len <= 1) {
            return "";
        } else {
            byte[] b = new byte[len];
            in.readBytes(b);
            return new String(b, 0, len - 1);
        }
    }

    public static byte[] deflate(byte[] in) {
        ByteArrayOutputStream bos = null;

        if (in != null) {
            ByteArrayInputStream bis = new ByteArrayInputStream(in);

            bos = new ByteArrayOutputStream();

            InflaterInputStream gis;

            try {
                gis = new InflaterInputStream(bis);

                byte[] buf = new byte[8192];
                int r = -1;

                while ((r = gis.read(buf)) > 0) {
                    bos.write(buf, 0, r);
                }
            } catch (IOException e) {
                bos = null;
            }
        }

        return (bos == null) ? null : bos.toByteArray();
    }

    private static final int MURMURHASH_M = 0x5bd1e995;

    public static long murMurHash(byte[] buffer, int len) {
        int h = 97 ^ len;
        int index = 0;

        while (len >= 4) {
            int k = (buffer[index] & 0xff) | ((buffer[index + 1] << 8) & 0xff00)
                | ((buffer[index + 2] << 16) & 0xff0000)
                | (buffer[index + 3] << 24);

            k *= MURMURHASH_M;
            k ^= (k >>> 24);
            k *= MURMURHASH_M;
            h *= MURMURHASH_M;
            h ^= k;
            index += 4;
            len -= 4;
        }

        switch (len) {
            case 3:
                h ^= (buffer[index + 2] << 16);

            case 2:
                h ^= (buffer[index + 1] << 8);

            case 1:
                h ^= buffer[index];
                h *= MURMURHASH_M;
        }

        h ^= (h >>> 13);
        h *= MURMURHASH_M;
        h ^= (h >>> 15);
        return ((long)h & 0xffffffffL);
    }

//    public static byte[] encodeCountValue(int count) {
//        // Nkv server cope with IncData by little-endian(dependable)
//        int flag = SoloConstant.NKV_STYPE_INCDATA;
//        flag <<= 1;
//        byte[] b = new byte[6];
//        b[1] = (byte)(flag & 0xFF);
//        b[0] = (byte)((flag >> 8) & 0xFF);
//        b[2] = (byte)(count & 0xFF);
//        b[3] = (byte)((count >> 8) & 0xFF);
//        b[4] = (byte)((count >> 16) & 0xFF);
//        b[5] = (byte)((count >> 24) & 0xFF);
//        return b;
//    }

    public static int decodeCountValue(byte[] b) {
        int rv = 0;
        int bits = 0;

        for (byte i : b) {
            rv |= (((i < 0) ? (256 + i)
                : i) << bits);
            bits += 8;
        }
        return rv;
    }

    public static byte[] objectToByte(Object obj) throws IOException {
        if (obj == null) {
            return null;
        }

        byte[] bytes = null;
        ByteArrayOutputStream bo = null;
        ObjectOutputStream oo = null;
        try {
            bo = new ByteArrayOutputStream();
            oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);
            bytes = bo.toByteArray();
        } finally {
            if (bo != null) {
                bo.close();
            }
            if (oo != null) {
                oo.close();
            }
        }

        return bytes;
    }

    public static Object byteToObject(byte[] bytes) throws IOException, ClassNotFoundException {
        if (bytes == null) {
            return null;
        }
        Object obj = null;
        ByteArrayInputStream bi = null;
        ObjectInputStream oi = null;
        try {
            bi = new ByteArrayInputStream(bytes);
            oi = new ObjectInputStream(bi);
            obj = oi.readObject();
        } finally {
            if (bi != null) {
                bi.close();
            }
            if (oi != null) {
                oi.close();
            }
        }
        return obj;
    }

    public static int getDuration(int expiretime) {
        int now = (int)(MillisecondClock.CLOCK.now() / 1000);
        if (expiretime > now) {
            expiretime -= now;
        }
        return expiretime;
    }

//    public static List<DataEntry> removeDuplicateKeys(List<DataEntry> keys) {
//        if (!CollectionUtils.isEmpty(keys)) {
//            List<DataEntry> tmp = new ArrayList<>();
//            Set<ByteArray> keyset = new HashSet<>();
//            for (DataEntry key : keys) {
//                boolean notExist = keyset.add(new ByteArray(key.getData()));
//                if (notExist) {
//                    tmp.add(key);
//                }
//            }
//            return tmp;
//        }
//        return null;
//    }

    static class BytesComparator implements Comparator<byte[]> {

        @Override
        public int compare(byte[] left, byte[] right) {
            for (int i = 0, j = 0; i < left.length && j < right.length; i++, j++) {
                int a = (left[i] & 0xff);
                int b = (right[j] & 0xff);
                if (a != b) {
                    return a - b;
                }
            }
            return left.length - right.length;
        }

    }

    @Data
    public static class CompressedValue {
        private byte[] value;
        private int length;
        private int olength;

        public int getSize() {
            return length + 8;
        }

        public void encode(ChannelBuffer buffer) {
            buffer.writeInt(length + 8);
            buffer.writeInt(FAST_COM_CODE);
            buffer.writeInt(olength);
            buffer.writeBytes(value, 0, length);
        }
    }
}
