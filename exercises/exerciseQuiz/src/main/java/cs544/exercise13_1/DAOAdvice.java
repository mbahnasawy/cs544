package cs544.exercise13_1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class DAOAdvice {

	@Around("execution( * cs544.exercise13_1.CustomerDAO.save(..))")
	public Object invoke(ProceedingJoinPoint call) throws Throwable {
		
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis(); 
		System.out.println("D");
		System.out.println("Time to execute save : " + totaltime);
		return retVal;
	}
}
