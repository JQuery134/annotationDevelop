package com;

import com.beanlifecycle.LifeCycle;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class MainConfigLifeCycle {
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean(initMethod = "init",destroyMethod = "destory")
    public LifeCycle lifeCycle(){
        return new LifeCycle();
    }
}
