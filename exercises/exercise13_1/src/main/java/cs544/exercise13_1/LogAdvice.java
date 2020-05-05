package cs544.exercise13_1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {
	
	@After("execution( * cs544.exercise13_1.EmailSender.*(..))")
	public void logSendEmailDate1(JoinPoint joinpoint) {
		System.out.println("Constructor");
		System.out.println(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").format(new Date()) +
				" method= "+ joinpoint.getSignature().getName());
	}

	@After("execution( * cs544.exercise13_1.EmailSender.sendEmail(..))")
	public void logSendEmailDate(JoinPoint joinpoint) {
		System.out.println("A");
		System.out.println(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").format(new Date()) +
				" method= "+ joinpoint.getSignature().getName());
	}
	
	@After("execution( * cs544.exercise13_1.EmailSender.sendEmail(..))")
	public void logSendEmailArgs(JoinPoint joinpoint) {
		System.out.println("B");
		System.out.println(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").format(new Date()) +
				" method= "+ joinpoint.getSignature().getName() 
				+ " address: " + (String)joinpoint.getArgs()[0]
				+ " message: " + (String)joinpoint.getArgs()[1]);
	}

	@After("execution( * cs544.exercise13_1.EmailSender.sendEmail(..))")
	public void logSendEmailTarget(JoinPoint joinpoint) {
		System.out.println("C");
		EmailSender target = (EmailSender)joinpoint.getTarget();
		System.out.println(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").format(new Date()) +
				" method= "+ joinpoint.getSignature().getName() 
				+ " address: " + (String)joinpoint.getArgs()[0]
				+ " message: " + (String)joinpoint.getArgs()[1]);
		System.out.println("Outgoing mail server = " + target.getOutgoingMailServer());
	}
	
}
