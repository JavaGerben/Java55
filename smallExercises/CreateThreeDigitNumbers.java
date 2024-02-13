public class CreateThreeDigitNumbers {
	public static void main (String[] args) {
		int correctCounter = 0;
		
		for (int firstDigit = 1; firstDigit <= 4; firstDigit++) {
			for (int secondDigit = 1; secondDigit <= 4; secondDigit++) {
				for (int thirdDigit = 1; thirdDigit <= 4; thirdDigit++) {
					if (firstDigit != secondDigit && firstDigit != thirdDigit && secondDigit != thirdDigit) {
						correctCounter++;
						System.out.println(firstDigit + "" + secondDigit + "" + thirdDigit);
					}
				}
			}
		}
		System.out.println("there are " + correctCounter + " combinations.");
	}
}