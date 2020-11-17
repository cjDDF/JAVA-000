package com.ddf;

import com.ddf.component.MyBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * xml配置
 * @author com.ddf
 */
public class MyApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyBean myBean = (MyBean) applicationContext.getBean("myBean");
        System.out.println(myBean);
    }
}
