package cs544.exercise12_1.bank.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Aspect
@Component
public class LogAdvice {

	@After("execution( * cs544.exercise12_1.bank.dao.*.*(..))")
	public void logDAO(JoinPoint joinpoint) {
		System.out.println("A");
		System.out.println("Log DAO: " + new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").format(new Date()) +
				" method= "+ joinpoint.getSignature().getName()) ;
	}
	
	@After("execution( * cs544.exercise12_1.bank.jms.*.*(..))")
	public void logJMS(JoinPoint joinpoint) {
		System.out.println("C");
		System.out.println("Log JMS: " + new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").format(new Date()) +
				" method= "+ joinpoint.getSignature().getName()) ;
	}
	
	@Around("execution( * cs544.exercise12_1.bank.service.*.*(..))")
	public Object invoke(ProceedingJoinPoint call) throws Throwable {
		
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis(); 
		System.out.println("B");
		System.out.println("Time to execute " + call.getSignature().getName() +": " + totaltime);
		return retVal;
	}
}
