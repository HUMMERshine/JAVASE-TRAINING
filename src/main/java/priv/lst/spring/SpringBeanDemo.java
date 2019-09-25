package priv.lst.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import priv.lst.domain.Person;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by lishutao on 2019-09-02.
 *
 * @author lishutao
 * @date 2019-09-02
 */
@Component
public class SpringBeanDemo implements BeanNameAware, BeanFactoryAware, ApplicationContextAware,
    InitializingBean, DisposableBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(Person.class);

    private static ApplicationContext applicationContext;
    private static BeanFactory beanFactory;

    @Autowired
    TestBean testBean;

    private String name;

    public SpringBeanDemo(){
        System.out.println("1、开始实例化 person ");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("2、设置 name 属性");
    }

    @Override
    public void setBeanName(String beanId) {
        System.out.println("3、Person 实现了 BeanNameAware 接口，Spring 将 Person 的 "
            + "ID=" + beanId + "传递给 setBeanName 方法");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("4、Person 实现了 BeanFactoryAware 接口，Spring 调"
            + "用 setBeanFactory()方法，将 BeanFactory 容器实例传入");
        SpringBeanDemo.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("5、Person 实现了 ApplicationContextAware 接口，Spring 调"
            + "用 setApplicationContext()方法，将 person 所在的应用上下文的"
            + "引用传入进来");
        SpringBeanDemo.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(testBean);
        System.out.println("8、Person 实现了 InitializingBean 接口，Spring 调用它的"
            + "afterPropertiesSet()方法。类似地，如果 person 使用 init-"
            + "method 声明了初始化方法，该方法也会被调用");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("13、Person 实现了 DisposableBean 接口，Spring 调用它的"
            + "destroy() 接口方法。同样，如果 person 使用 destroy-method 声明"
            + "了销毁方法，该方法也会被调用");
    }

    /**
     * xml 中声明的 init-method 方法
     */
    public void initMethod(){
        System.out.println("9、xml 中声明的 init-method 方法");
    }

    /**
     * xml 中声明的 destroy-method 方法
     */
    public void destroyMethod(){
        System.out.println("14、xml 中声明的 destroy-method 方法");
        System.out.println("end---------------destroy-----------------");
    }

    // 自定义初始化方法
    @PostConstruct
    public void springPostConstruct(){
        System.out.println("7、@PostConstruct 调用自定义的初始化方法");
    }

    // 自定义销毁方法
    @PreDestroy
    public void springPreDestory(){
        System.out.println("12、@PreDestory 调用自定义销毁方法");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize 方法");
    }

}
