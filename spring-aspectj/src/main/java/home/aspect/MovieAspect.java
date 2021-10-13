package home.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MovieAspect {
	
	@Before("execution(* home.service.MovieService.*(..))")
	public void before(Joinpoint joinPoint) {
		System.out.println("movieaspect >> before <<");
	}
	@After("execution(* home.service.MovieService.*(..))")
	public void after(Joinpoint joinPoint) {
		System.out.println("movieaspect >> after <<");
	}
	@AfterReturning(
			pointcut="execution(* home.service.MovieService.*(..))",
			returning = "movieName" )
	public void afterReturning(Joinpoint joinPoint,Object movieName) {
		System.out.println("movieaspect >> aftereturning <<");
	}
}
