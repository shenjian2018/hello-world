package KeyS;

public class BO {

	public static int Recursion(int n) {

		if (n == 1) {
			return 0;
		}

		if (n == 2) {
			return 1;
		}
		return Recursion(n - 1) + Recursion(n - 2);
	}

	public static void main(String[] args) {
		int c = BO.Recursion(10);
		System.out.println(c);
  
	}
}
