package hoofdstuk4;
import util.*;
import java.util.*;

public class Hoofdstuk4Array {
	public static void main (String[] main) {
		Scanner myScanner = new Scanner(System.in);
		
		AskForNumberInRange temp = new AskForNumberInRange("Voer het aantal items in: ", 0, 100);
		int NUM_ITEMS = temp.getResult();
		System.out.println("Voer de waarde van alle items in (gescheiden door spatie): ");
		
		String numbersString = myScanner.nextLine();
		numbersString = numbersString.trim();
		String numbersArray[] = numbersString.split(" ");
		int[] numbersInt = new int[NUM_ITEMS];
		
		for(int i = 0; i < numbersArray.length; i++)
		{
			try {
				numbersInt[i] = Integer.parseInt(numbersArray[i]);
			} catch (ArrayIndexOutOfBoundsException ignored) {}
		}
		
		System.out.println("De waarden zijn: " + Arrays.toString(numbersInt));
		System.out.println();
		System.out.println();
		
		for (int i : numbersInt) {
			for (int ii = 0; ii < i; ii++) {
				System.out.print("*");
			}
			System.out.print("(" + i + ")\n");
		}
	}
}