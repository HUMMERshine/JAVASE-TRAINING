package priv.lst.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.*;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by lishutao on 2018/8/13.
 *
 * @author lishutao
 * @date 2018/8/13
 */
@Service
public class ApplicationContextDemo implements ApplicationContextAware {
    public static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        T object = context.getBean(clazz);
        return object;
    }

    public static Object getBean(String beanName) {
        Object object = context.getBean(beanName);
        return object;
    }
}
