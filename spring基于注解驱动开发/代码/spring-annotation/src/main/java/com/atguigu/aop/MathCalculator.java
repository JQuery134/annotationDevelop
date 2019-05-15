package com.atguigu.aop;

public class MathCalculator {
	
	public int div(int i,int j){
		System.out.println("执行目标方法");
		return i/j;	
	}

}
