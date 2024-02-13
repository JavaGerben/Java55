public class EvenSumOfDigits {
	public static void main (String[] args) {
		for (int i = 101; i < 150; i++) {
			int digids = i % 10;
			int tens = ((i % 100) - digids) / 10;
			int hundreds = i / 100;
			int total = digids + tens + hundreds;
			
			if (total % 2 == 0) {
				System.out.println(i);
			}
		}
	}
}