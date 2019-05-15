package com.annotation.driver.develop.annotationDevelop;

import com.MainConfig;
import com.MainConfigLifeCycle;
import com.beanlifecycle.LifeCycle;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * 注解方式将Bean注入容器的方法：
 * 1、通过ComponentScan扫描(Controller、Service、Repository)
 * 2、通过@Bean
 * 2、通过@Import
 *         ImoprtSelector：返回需要导入的组件的全类名
 *         ImportBeanDefinitionRegistrar：手动注入bean到容器中
 * 4、通过@FactoryBean（工厂Bean）
 */
public class TesAnnotationForSpring {

    private static final Logger logger = LoggerFactory.getLogger(TesAnnotationForSpring.class);

    private static AnnotationConfigApplicationContext annotationConfigApplicationContext = null;
    private static AnnotationConfigApplicationContext applicationContextLifeCycle = null;
    static {
        annotationConfigApplicationContext =new AnnotationConfigApplicationContext(MainConfig.class);
        applicationContextLifeCycle =new AnnotationConfigApplicationContext(MainConfigLifeCycle.class);
    }


    @Test
    public void testLifeCycle(){
        String[] beanDefinitionNames = applicationContextLifeCycle.getBeanDefinitionNames();
        logger.info("========================输出IOC容器中的bean开始========================");
        for (String beanName : beanDefinitionNames){
            logger.info(beanName);
        }
        logger.info("========================输出IOC容器中的bean结束========================");
        LifeCycle lifeCycle = (LifeCycle)applicationContextLifeCycle.getBean("lifeCycle");
        logger.info("========================LifeCycle========================");

    }

    @Test
    public void testImoprtSelector(){
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        logger.info("========================输出IOC容器中的bean开始========================");
        for (String beanName : beanDefinitionNames){

            logger.info(beanName);
        }
        logger.info("========================输出IOC容器中的bean结束========================");

        Object colorFactoryBean = annotationConfigApplicationContext.getBean("colorFactoryBean");
        logger.info("========================colorFactoryBean的类型========================");
        logger.info(String.valueOf(colorFactoryBean.getClass()));

    }


}
