package cs544.exercise13_1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

public class QuizAdvice {

	private String text;

	public QuizAdvice() {
		System.out.println("TraceAdvice Constructor ­ text: " + text);
	}

	public void setText(String text) {
		this.text = text;
	}

	public void start() {
		System.out.println("TraceAdvice start method ­ text: " + text);
	}

	@Before("execution(* cs544.exercise13_1.*.*(..))")
	public void beforeTrace(JoinPoint jp) {
		System.out.println("Before: " + jp.getSignature().getName());
	}

}
