package home.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MovieTrackerAfter implements AfterReturningAdvice {

	// advice after
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("tracking >> aftereturning ..."+method.getName());
		
	}
	

}
