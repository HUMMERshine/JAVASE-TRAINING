package priv.lst.arch.localcache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by lishutao on 2018/7/27.
 *
 * @author lishutao
 * @date 2018/7/27
 */
public class GuavaCache {
    private static Logger log = Logger.getLogger(GuavaCache.class);

    public LoadingCache buildCache(Long time) {
        return CacheBuilder.newBuilder()
            .expireAfterWrite(time, TimeUnit.MINUTES)
            .build(new CacheLoader<Long, AtomicLong>() {
                @Override
                public AtomicLong load(Long key) throws Exception {
                    return new AtomicLong(0);
                }
            });
    }

}
