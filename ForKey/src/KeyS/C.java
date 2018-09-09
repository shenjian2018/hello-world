package KeyS;

public class C extends B implements A {
	public void px(int x) {
		System.out.println(x);

	}

	public static void main(String[] args) {

		new C().px(A.x);
	}
}
