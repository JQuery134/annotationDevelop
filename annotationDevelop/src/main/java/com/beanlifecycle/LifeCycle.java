package com.beanlifecycle;

import org.springframework.context.annotation.Configuration;

public class LifeCycle {

    public LifeCycle() {
        System.out.println("======构造方法======");
    }

    public void init(){
        System.out.println("======初始化======");
    }

    public void destory(){
        System.out.println("======销毁======");
    }
}
