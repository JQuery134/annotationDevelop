package com.annotation.driver.develop.annotationDevelop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AnnotationDevelopApplication {


	private static final Logger logger = LoggerFactory.getLogger(AnnotationConfigApplicationContext.class);
	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(AnnotationDevelopApplication.class, args);
		String[] beans = configurableApplicationContext.getBeanDefinitionNames();
		logger.info("========================输出IOC容器中的bean开始========================");
		for (String bean : beans){
			logger.info(bean);
		}
		logger.info("========================输出IOC容器中的bean结束========================");

	}

}
