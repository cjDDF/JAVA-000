package com.ddf;

import com.ddf.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 注解
 * @author com.ddf
 */
public class MyApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Object myBean = applicationContext.getBean("myBean");
        System.out.println(myBean);

        Object testBean = applicationContext.getBean("testBean");
        System.out.println(testBean);
    }
}
