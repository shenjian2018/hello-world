package KeyS;

public class Question {
	public static boolean isOdd(int i) {
		if (i % 2 == 1) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; ++i) {
			Boolean isodd = Question.isOdd(i);
			System.out.println(String.format("i=%d,isOdd=%b", i, isodd));
		}
	}

}
