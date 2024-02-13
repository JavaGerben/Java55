public class Hoofdstuk4String {
	public static void main (String[] main) {
		String randomString = "leel";
		boolean palindroom = false;
		int palidroomChar = 0;
		
		System.out.println("The starting string is: " + randomString);
		System.out.print("The reverse is: ");
		for (int i = randomString.length() - 1; i > 0; i--) {
			System.out.print(randomString.charAt(i));
			if (i > randomString.length()/2) {
				if (randomString.charAt(i) == randomString.charAt(palidroomChar)) {
					palindroom = true;
				}
			}
		}
		System.out.println();
		System.out.println();
		if (palindroom) {
			System.out.println(randomString + " is a palindroom.");
		} else {
			System.out.println(randomString + " is not a palindroom.");
		}
	}
}