package home.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MovieTrackerAround implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("Around... method name " + invocation.getMethod().getName());
		System.out.println("Around... method name " + invocation.getArguments());
		
		try {
			// before
			System.out.println("Around ... >> before");
			Object result = invocation.proceed();
			// after >> commit
			System.out.println("Around ... >> after commit");
		} catch (Exception e) {
			// rollback
			System.out.println("Around ... >> throw exception rollback");
		}
		
		return null;
	}
					
}
