package cs544.exercise13_1;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppQuiz {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		System.out.println("Testing Spring Startup");
		MyClass mc = context.getBean("myClass", MyClass.class);
		mc.sayHello();
	}

}
