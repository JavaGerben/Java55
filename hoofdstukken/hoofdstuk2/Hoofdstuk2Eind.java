import java.util.Scanner;

public class Hoofdstuk2Eind {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.print("Geef een geheel positief getal: ");
		int numberInput = myScanner.nextInt();
		
		int unevenTotal = allUnevenChecker(numberInput);
		int evenTotal = allEvenChecker(numberInput);
		System.out.println(unevenTotal);
		System.out.println(evenTotal);
		System.out.println(unevenTotal - evenTotal);
	}
	
	static int allUnevenChecker(int numberInput) {
		int total = 0;
		for (int i = 1; i <= numberInput; i += 2) {
			total += i;
		}
		return total;
	}
	
	static int allEvenChecker(int numberInput) {
		int total = 0;
		for (int i = 2; i <= numberInput; i += 2) {
			total += i;
		}
		return total;
	}
}