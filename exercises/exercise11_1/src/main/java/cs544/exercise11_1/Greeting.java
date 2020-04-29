package cs544.exercise11_1;

public class Greeting {

	private String greeting;

	public Greeting() {

	}

	public Greeting(String greeting) {
		super();
		this.greeting = greeting;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public void sayHello() {
		System.out.println(greeting);
	}

}
