package home.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MovieTrackerBefore implements MethodBeforeAdvice{

	//advice before
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("tracking >> before ..."+method.getName());
	}
	
	
}
