package KeyS;

public class ClassB extends ClassA {

	public ClassB() {
		System.out.println("Hello B");
	}

	{
		System.out.println("I'm B Class");
	}
	static {
		System.out.println("static B");
	}

	public static void main(String[] args) {
            new ClassB();
	}
}
