package com.importSelector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class MyImportSelector implements ImportSelector {
    /**
     *
     * @param importingClassMetadata 当前标注@Import注解的类的注解信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes("org.springframework.context.annotation.Import");
//        System.out.println("使用@Import注解的属性值："+annotationAttributes);
        //一系列逻辑判断

        return new String[]{"com.importSelector.Blue"};
    }
}
