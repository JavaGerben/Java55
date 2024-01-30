public class Front9 {
	public static void main (String[] args) {
		System.out.println(checkFor9(1, 2, 4, 2, 9));
		System.out.println(checkFor9(9, 2, 4, 2, 9));
		System.out.println(checkFor9(1, 2, 4, 2, 9));
		System.out.println(checkFor9(1, 9, 4, 2, 9));
	}
	
	private static boolean checkFor9 (int... numbers) {
		for (int i = 0; i < numbers.length; i++) {
			if (i <= 3 && numbers[i] == 9) return true;
			else if (i > 3) return false;
		}
		return false; 
	}
}