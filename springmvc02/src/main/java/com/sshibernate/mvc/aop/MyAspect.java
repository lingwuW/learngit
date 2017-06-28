package com.sshibernate.mvc.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * <aop:aspectj-autoproxy /><!-- Spring AOP配置 -->
 * <!-- 启动@AspectJ支持   可以指定动态代理类型 -->
 * <bean class="org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator"></bean>
 * */
@Component
@Aspect
public class MyAspect {
	@Pointcut(value="execution(* com.sshibernate.mvc.service..*.*(..))")
	public void aspect(){
		
	}
	//value="execution(* com.spring.mvc.service.*.*(..))"定义切入点表达式expression
	@Before(value="aspect()")
	public void doBefore(){
		System.out.println("++++++++++dobefore+++++++");
	}
	
	@After(value="aspect()")
	public void doAfter(){
		System.out.println("++++++++++doAfter+++++++");
	}
	
	@AfterReturning(value="aspect()")
	public void doAfterReturn(){
		System.out.println("目标方法完成后++after-return");
	}
	
	@AfterThrowing(value="aspect()")
	public void doAfterThrow(){
		System.out.println("目标方法异常++after-throw");
	}
	
}
