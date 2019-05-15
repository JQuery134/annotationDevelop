package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 切面类
 *
 */
@Aspect
public class LogAspect {

    @Before("execution(public int com.aop.Calculator.add(int,int))")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(""+joinPoint.getSignature().getName()+"运行。。。@Before:参数列表是：{"+ Arrays.asList(args)+"}");
    }

    @Around("execution(public int com.aop.Calculator.add(int,int))")
    public int arround(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("日志执行前");

        joinPoint.proceed();
        System.out.println("日志执行后");

        return new Integer(3);

    }

}
