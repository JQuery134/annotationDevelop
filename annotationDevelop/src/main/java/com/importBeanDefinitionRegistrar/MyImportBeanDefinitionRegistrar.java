package com.importBeanDefinitionRegistrar;

import com.importSelector.RainBow;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     *
     * @param importingClassMetadata 当前使用@Import注解的类的注解信息
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        Boolean beanDefinition = registry.containsBeanDefinition("com.importSelector.Red");
        Boolean beanDefinition1 = registry.containsBeanDefinition("com.importSelector.Blue");
        if (beanDefinition && beanDefinition1){
            BeanDefinition beanDefinition2 = new RootBeanDefinition(RainBow.class);
            registry.registerBeanDefinition("rainBow",beanDefinition2);
        }

    }
}
