package com;

import com.aop.Calculator;
import com.aop.LogAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class MainConfigAop {
    /**
     * 将业务类和切面类注入到容器中
     * @return
     */

    @Bean
    public Calculator calculator(){
        return new Calculator();
    }

    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }

}
