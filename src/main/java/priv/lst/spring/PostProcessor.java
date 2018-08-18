package priv.lst.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

/**
 * Created by lishutao on 2018/8/13.
 *
 * @author lishutao
 * @date 2018/8/13
 */
@Configurable
public class PostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
        throws BeansException {
        System.out.println("------------------------------");
        System.out.println("对象" + beanName + "开始实例化");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
        throws BeansException {
        System.out.println("对象" + beanName + "实例化完成");
        System.out.println("------------------------------");
        return bean;
    }

}