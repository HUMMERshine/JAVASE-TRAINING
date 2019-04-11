import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.junit.Test;
import priv.lst.arch.test.MillisecondClock;
import priv.lst.domain.Student;
import priv.lst.ehcache.User;
import priv.lst.util.NkvUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * Created by lishutao on 2018/6/15.
 *
 * @author lishutao
 * @date 2018/6/15
 */
public class testIgnite {
    @Test
    public void test1() {
        Maps.newHashMap();
        TcpDiscoverySpi spi = new TcpDiscoverySpi();
        TcpDiscoveryVmIpFinder ipFinder = new TcpDiscoveryVmIpFinder();
        ipFinder.setAddresses(Arrays.asList("127.0.0.1:47500..47509"));
        spi.setIpFinder(ipFinder);
        IgniteConfiguration cfg = new IgniteConfiguration();
        cfg.setDiscoverySpi(spi);
        cfg.setClientMode(true);

        Ignite ignite = Ignition.start(cfg);
    }

    @Test
    public void test3() throws InterruptedException, Exception {
        int count = 10;
        while (count-- > 0) {
            System.out.println(MillisecondClock.CLOCK.now());
            Thread.sleep(50);
        }
        System.out.println(MillisecondClock.CLOCK.now());
        MillisecondClock.CLOCK.t.interrupt();
        Thread.sleep(1000);
        System.out.println(MillisecondClock.CLOCK.now());
    }

    @Test
    public <T> void test4() {
        String group = "1001";
        System.out.println(group);
        System.out.println(group + "\0");
        char ch = '\0';
        System.out.println(ch);
        System.out.println("1");
        int chi = '1';
        int ch0 = '\0';
        System.out.println(chi);
        System.out.println(ch0);
        System.out.println('1' - '\0');

        String x = String.class.cast("123");
        System.out.println(x);

        int y = 1;
        System.out.printf("%x, %d\n", y, y);
        y = 0x22;
        System.out.printf("%x, %d\n", y, y);
    }

    @Test
    public <T> void test5() {
        List<Integer> person = JSONObject.parseObject("[\"0\",\"50\",\"80\",\"100\",\"200\",\"500\"]", new TypeReference<List<Integer>>() {
        });
        System.out.println(person);

        Long l = JSONObject.parseObject("100", new TypeReference<Long>() {
        });
        System.out.println(l);

        String s = JSONObject.parseObject("-1", new TypeReference<String>() {
        });
        System.out.println(s);

        System.out.println(TT.JAVAAPP.toString());
    }

    @Test
    public <T> void test6() {
        byte[] bytes = "".getBytes();
        System.out.println(bytes);
    }

    @Test
    public void test7() {
        Pattern pattern = Pattern.compile("(ssh://g.hz.netease.com/).*");
        System.out.println(pattern.matcher("ssh://g.hz.neteae.com/xxx").matches());
//        "hell".startsWith()

        User user = new User("xxx", "xxx");
        user.setName("hello");
        user.setCode("world");
        System.out.println(user);
    }

    @Test
    public void test8() throws IOException {

        System.out.println(Arrays.toString(ByteBuffer.allocate(4).putInt(10).array()));

        byte[] str = "hello world!, hello world!".getBytes();
        byte[] desStr = NkvUtil.decompress(str);

        System.out.println(Arrays.toString(str));
        System.out.println(Arrays.toString(desStr));

        str = new byte[9000];
        str[0] = 1;
        NkvUtil.CompressedValue compressedValue = NkvUtil.compress(str);
//         = new byte[compressedValue.getSize()];
        ByteArrayOutputStream bio = new ByteArrayOutputStream();
        bio.write(ByteBuffer.allocate(4).putInt(NkvUtil.FAST_COM_CODE).array());
        bio.write(ByteBuffer.allocate(4).putInt(compressedValue.getOlength()).array());
        bio.write(compressedValue.getValue());
        byte[]  compresStr = bio.toByteArray();

        System.out.println(Arrays.toString(str));
        System.out.println(Arrays.toString(compresStr));

    }

    @Test
    public void test9() {
        Map<String, String> map1 = Maps.newHashMap();
        Map<String, String> map2 = Maps.newHashMap();

        map1.put("key1", "hello");
        map1.put("key2", "world");

        map2.put("key2", "world");
        map2.put("key1", "hello");

        String str1 = JSON.toJSONString(map1);
        String str2 = JSON.toJSONString(map2);

        JSONObject.parseObject(str2);

        System.out.println(StringUtils.equals(str1, str2));
    }

    @Test
    public void test10() {
        String [] strArray = "asdfasdfas/asfasfasd/asdfasfasd".split("/");

        System.out.println(Arrays.toString(strArray));

        System.out.println(TT.JAVAAPP.getName());
    }

    @Test
    public void stopWatch() {
        try {
            Stopwatch watch = Stopwatch.createStarted();
            System.out.println("xxx");
            long l = watch.stop().elapsed(TimeUnit.MILLISECONDS);
            System.out.println(l);
        } catch (Exception e) {
            System.out.println("l");
        }
    }

    enum TT {
        UNKNOWN(-1, "unknown"),
        JAVAAPP(1, "java app"),
        JAVAWEB(2, "java web"),
        STATIC_RESOURCE(3, "静态资源"),
        NODEJS(4, "nodeJs"),
        SELF_DEFINE(5, "自定义"),
        PHP(6, "PHP"),
        PYTHON(7, "python");


        @Getter
        Integer type;

        @Getter
        String name;

        TT(Integer type, String name) {
            this.type = type;
            this.name = name;
        }
    }
}
