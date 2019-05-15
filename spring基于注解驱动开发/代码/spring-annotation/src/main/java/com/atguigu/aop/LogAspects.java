package com.atguigu.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * ������
 * @author lfy
 * 
 * @Aspect�� ����Spring��ǰ����һ��������
 *
 */
@Aspect
public class LogAspects {
	
	//��ȡ�������������ʽ
	//1����������
	//2����������������
	@Pointcut("execution(public int com.atguigu.aop.MathCalculator.*(..))")
	public void pointCut(){};
	
	//@Before��Ŀ�귽��֮ǰ���룻�������ʽ��ָ�����ĸ��������룩
	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();
		System.out.println(""+joinPoint.getSignature().getName()+"���С�����@Before:�����б��ǣ�{"+Arrays.asList(args)+"}");
	}
	
	@After("com.atguigu.aop.LogAspects.pointCut()")
	public void logEnd(JoinPoint joinPoint){
		System.out.println(""+joinPoint.getSignature().getName()+"����������@After");
	}
	
	//JoinPointһ��Ҫ�����ڲ�����ĵ�һλ
	@AfterReturning(value="pointCut()",returning="result")
	public void logReturn(JoinPoint joinPoint,Object result){
		System.out.println(""+joinPoint.getSignature().getName()+"�������ء�����@AfterReturning:���н����{"+result+"}");
	}
	
	@AfterThrowing(value="pointCut()",throwing="exception")
	public void logException(JoinPoint joinPoint,Exception exception){
		System.out.println(""+joinPoint.getSignature().getName()+"�쳣�������쳣��Ϣ��{"+exception+"}");
	}

	@Around(value = "pointCut()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint){

		Object result = null;
		try {
			//ִ��Ŀ�귽��
			result = proceedingJoinPoint.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}

		return result;

	}


	/**
	 * ����֪ͨ
	 */
	/*@Around("execution(public int lzj.com.spring.aop.ArithmeticCalculator.*(int, int))")
	public Object aroundMethod(ProceedingJoinPoint pdj){
		*//*resultΪ���ӵ�ķŻؽ��*//*
		Object result = null;
		String methodName = pdj.getSignature().getName();

		*//*ǰ��֪ͨ����*//*
		System.out.println("ǰ��֪ͨ����>Ŀ�귽������" + methodName + ",����Ϊ��" + Arrays.asList(pdj.getArgs()));

		*//*ִ��Ŀ�귽��*//*
		try {
			result = pdj.proceed();

			*//*����֪ͨ����*//*
			System.out.println("����֪ͨ����>Ŀ�귽����" + methodName + ",���ؽ��Ϊ��" + result);
		} catch (Throwable e) {
			*//*�쳣֪ͨ����*//*
			System.out.println("�쳣֪ͨ����>Ŀ�귽����" + methodName + ",�쳣Ϊ��" + e);
			*//*������֪ͨ���������������쳣ʱ�������ӵ㷽�����ֵ��쳣����ʱ�׳���*//*
			throw new RuntimeException();
		}

		*//*����֪ͨ*//*
		System.out.println("����֪ͨ����>Ŀ�귽����" + methodName);

		return result;
	}*/

}