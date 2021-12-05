package home.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MovieAspect {
	
	@Before("execution(* home.service.MovieService.addMovie(..))")
	public void before(JoinPoint joinPoint) {
		System.out.println("Movie Aspect >> before <<");
	}
	
	@After("execution(* home.service.MovieService.addMovie(..))")
	public void after(JoinPoint joinPoint) {
		System.out.println("Movie Aspect >> after <<");
	}
	
	@AfterReturning(
			pointcut = "execution(* home.service.MovieService.*(..))",
			returning = "movieName"
	)
	public void afterReturning(JoinPoint joinPoint, Object movieName) {
		System.out.println("Movie Aspect >> afterReturning <<");
		System.out.println("Return result:" + movieName);
	}
}
