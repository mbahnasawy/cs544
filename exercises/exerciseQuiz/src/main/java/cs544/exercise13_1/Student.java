package cs544.exercise13_1;

public class Student extends Person{

	public Student(String text) {
		setText(text);
		System.out.println("MyClass Constructor");
	}

	public void sayHello() {
		System.out.println("This is a " + getText());
	}
}
