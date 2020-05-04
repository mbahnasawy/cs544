package cs544.exercise13_1;

public class MyClass extends MySuper{

	public MyClass(String text) {
		setText(text);
		System.out.println("MyClass Constructor");
	}

	public void sayHello() {
		System.out.println("This is a " + getText());
	}
}
