package com.atguigu;

import com.atguigu.aop.MathCalculator;
import com.atguigu.config.MainConfigOfAOP;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;

public class MainTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//		Person bean = (Person) applicationContext.getBean("person");
//		System.out.println(bean);
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
		MathCalculator mathCalculator = (MathCalculator)applicationContext.getBean(MathCalculator.class);
		mathCalculator.div(1,1);
	
	}

}
