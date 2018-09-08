package priv.lst.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * Created by lishutao on 2018/8/13.
 *
 * @author lishutao
 * @date 2018/8/13
 */
@Service
public class TestBean implements InitializingBean {
    String name;

    public TestBean() {
        super();
        System.out.println("***********");
        System.out.println("构造函数");
        System.out.println("***********");
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void init() {
        System.out.println("init-method is called");
        System.out.println("******************************");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("******************************");
        System.out.println("afterPropertiesSet is called");
        System.out.println("******************************");
    }
}
