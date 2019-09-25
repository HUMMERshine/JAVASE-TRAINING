package priv.lst.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import priv.lst.domain.Person;

/**
 * Created by lishutao on 2018/8/13.
 *
 * @author lishutao
 * @date 2018/8/13
 */
@Component
@Configurable
public class PostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
        throws BeansException {
        if(bean instanceof SpringBeanDemo){
            System.out.println("6、初始化 Person 之前执行的方法");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
        throws BeansException {
        if(bean instanceof SpringBeanDemo){
            System.out.println("6、初始化 Person 之后执行的方法");
        }
        return bean;
    }

}