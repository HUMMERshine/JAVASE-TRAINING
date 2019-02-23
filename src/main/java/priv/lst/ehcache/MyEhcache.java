package priv.lst.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by lishutao on 2019/2/23.
 *
 * @author lishutao
 * @date 2019/2/23
 */
@Service
public class MyEhcache {

    @Autowired
    CacheManager cacheManager;

    public Element test() {
        User user = new User("hello", "world");
        Cache demo = cacheManager.getCache("demoCache");
        demo.put(new Element(user.getName(), user));
        Element e=(Element)demo.get(user.getName());
        return e;
    }

}
