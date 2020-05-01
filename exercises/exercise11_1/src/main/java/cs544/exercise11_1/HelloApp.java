package cs544.exercise11_1;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		System.out.println("Testing Spring Startup");
		ClassA classA = context.getBean("classA", ClassA.class);
		classA.showText();
		context.close();

	}

}
