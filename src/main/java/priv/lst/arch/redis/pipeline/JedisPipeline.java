package priv.lst.arch.redis.pipeline;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.util.Pool;

/**
 * Created by lishutao on 2018/8/3.
 *
 * @author lishutao
 * @date 2018/8/3
 */
public class JedisPipeline {
    protected Pool<Jedis> jedisPool;

    private Jedis jedis;

    private Pipeline pipeline;

    public JedisPipeline(Pool<Jedis> jedisPool) {
        this.jedisPool = jedisPool;
    }

    public void open(){
        this.jedis = jedisPool.getResource();
        this.pipeline = this.jedis.pipelined();
    }

    public void syncAndChange() {
        this.pipeline.sync();
        this.jedis.close();
        this.jedis = jedisPool.getResource();
        this.pipeline = this.jedis.pipelined();
    }

    public void close(int size) {
        if (size > 0) {
            this.pipeline.sync();
        }
        this.jedis.close();
    }

    public void close() {
        this.jedis.close();
    }
    public Jedis getJedis() {
        return this.jedis;
    }

    public Pipeline getPipeline() {
        return this.pipeline;
    }



}
