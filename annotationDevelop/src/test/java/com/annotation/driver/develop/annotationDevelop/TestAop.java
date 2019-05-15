package com.annotation.driver.develop.annotationDevelop;

import com.MainConfig;
import com.MainConfigAop;
import com.MainConfigLifeCycle;
import com.aop.Calculator;
import com.beanlifecycle.LifeCycle;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAop {

    private static final Logger logger = LoggerFactory.getLogger(TesAnnotationForSpring.class);

    private static AnnotationConfigApplicationContext applicationContextAop = null;
    static {
        applicationContextAop =new AnnotationConfigApplicationContext(MainConfigAop.class);
    }


    @Test
    public void testAop(){
        Calculator calculator = (Calculator)applicationContextAop.getBean("calculator");
        calculator.add(1,1);

    }
}
