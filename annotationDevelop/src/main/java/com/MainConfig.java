package com;

import com.Filter.MyFilter;
import com.componentScan.MyService;
import com.importBeanDefinitionRegistrar.MyImportBeanDefinitionRegistrar;
import com.importSelector.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * @AliasFor注解的使用：https://blog.csdn.net/zhaole524/article/details/80836172
 */
@ComponentScan(value = "com.componentScan",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = MyService.class),
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = MyFilter.class)
})
//@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class), ：按照注解类型过滤
//@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = RainBow.class): 按照指定的类型过滤

@Configuration(value = "mainConfig")
@Import(value = {Black.class,Red.class,MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig {

    @Bean
    public Green green(){
        return new Green();
    }

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
