package com.atguigu.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 切面类
 * @author lfy
 * 
 * @Aspect： 告诉Spring当前类是一个切面类
 *
 */
@Aspect
public class LogAspects {
	
	//抽取公共的切入点表达式
	//1、本类引用
	//2、其他的切面引用
	@Pointcut("execution(public int com.atguigu.aop.MathCalculator.*(..))")
	public void pointCut(){};
	
	//@Before在目标方法之前切入；切入点表达式（指定在哪个方法切入）
	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();
		System.out.println(""+joinPoint.getSignature().getName()+"运行。。。@Before:参数列表是：{"+Arrays.asList(args)+"}");
	}
	
	@After("com.atguigu.aop.LogAspects.pointCut()")
	public void logEnd(JoinPoint joinPoint){
		System.out.println(""+joinPoint.getSignature().getName()+"结束。。。@After");
	}
	
	//JoinPoint一定要出现在参数表的第一位
	@AfterReturning(value="pointCut()",returning="result")
	public void logReturn(JoinPoint joinPoint,Object result){
		System.out.println(""+joinPoint.getSignature().getName()+"正常返回。。。@AfterReturning:运行结果：{"+result+"}");
	}
	
	@AfterThrowing(value="pointCut()",throwing="exception")
	public void logException(JoinPoint joinPoint,Exception exception){
		System.out.println(""+joinPoint.getSignature().getName()+"异常。。。异常信息：{"+exception+"}");
	}

	@Around(value = "pointCut()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint){

		Object result = null;
		try {
			//执行目标方法
			result = proceedingJoinPoint.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}

		return result;

	}


	/**
	 * 环绕通知
	 */
	/*@Around("execution(public int lzj.com.spring.aop.ArithmeticCalculator.*(int, int))")
	public Object aroundMethod(ProceedingJoinPoint pdj){
		*//*result为连接点的放回结果*//*
		Object result = null;
		String methodName = pdj.getSignature().getName();

		*//*前置通知方法*//*
		System.out.println("前置通知方法>目标方法名：" + methodName + ",参数为：" + Arrays.asList(pdj.getArgs()));

		*//*执行目标方法*//*
		try {
			result = pdj.proceed();

			*//*返回通知方法*//*
			System.out.println("返回通知方法>目标方法名" + methodName + ",返回结果为：" + result);
		} catch (Throwable e) {
			*//*异常通知方法*//*
			System.out.println("异常通知方法>目标方法名" + methodName + ",异常为：" + e);
			*//*当环绕通知方法本身还有其它异常时，非连接点方法出现的异常，此时抛出来*//*
			throw new RuntimeException();
		}

		*//*后置通知*//*
		System.out.println("后置通知方法>目标方法名" + methodName);

		return result;
	}*/

}