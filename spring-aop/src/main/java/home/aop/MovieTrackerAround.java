package home.aop;

import org.aopalliance.intercept.Interceptor;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MovieTrackerAround implements MethodInterceptor{

	//around 
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("Around....method name"+ invocation.getMethod().getName());
		System.out.println("Around....method agument"+ invocation.getArguments());
		Object result=null;
		try {
			//before
			System.out.println("around....>> before");
			result =invocation.proceed();
			System.out.println("around...>>after");
		 //after
		} catch  (Exception e) {
			System.out.println("around...>>throw exception rollback");
		}
		
		System.out.println("around after returning...."+ result);
		return result;
	}

}
