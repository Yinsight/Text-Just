package TextJustification;

public class Question1 {

	public static int badness(String[] W, int i, int j, int width) {
		int temp = width - l(W, i, j); // Calculation the condition value
		if (temp >= 0)
			return (int) Math.pow(temp, 3);// In that function if x>=0 return x^3

		return Integer.MAX_VALUE;// if not then return an infinite number
	}

	public static int l(String[] W, int a, int b) {

		int num = 0; // the total length in characters of the words
		for (int i = a; i < b; i++) {
			num += W[i].length();// Accumulate the length of each line of the text Without spaces
		}
		num += b - a - 1;
		return num;
	}

}
