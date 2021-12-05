package home.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MovieTrackerAfter implements AfterReturningAdvice {
	
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Tracking >> after runing method..." + method.getName());
	}
}
