//package priv.lst.arch.redis.pipeline;
//
//import redis.clients.jedis.Client;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.PipelineBase;
//import redis.clients.util.JedisClusterCRC16;
//import redis.clients.util.SafeEncoder;
//
//import java.io.Closeable;
//import java.io.IOException;
//
///**
// * Created by lishutao on 2018/8/6.
// *
// * @author lishutaoCollectors.toMap
// * @date 2018/8/6
// */
//public class JedisClusterPipeline extends PipelineBase implements Closeable {
//
//
//
//    @Override
//    public void close() throws IOException {
//
//    }
//
//    @Override
//    protected Client getClient(String s) {
//        byte[] bytes = SafeEncoder.encode(s);
//
//        return getClient(bytes);
//    }
//
//    @Override
//    protected Client getClient(byte[] bytes) {
//        Jedis jedis = getJedis(JedisClusterCRC16.getSlot(bytes));
//        Client client = jedis.getClient();
//        clients.add(client);
//
//        return client;
//    }
//
//    private Jedis getJedis(int slot){
//        JedisPool jedisPool = clusterInfoCache.getSlotPool(slot);
//
//        Jedis jedis = jedisPoll2Jedis.get(jedisPool);
//        if (jedis == null) {
//            jedis = jedisPool.getResource();
//            jedisPool2Jedis.put(jedisPool, jedis);
//        }
//
//        hasDataInBuf = true;
//        return jedis;
//    }
//}
