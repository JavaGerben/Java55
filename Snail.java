import java.util.Scanner;

public class Snail {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.print("how big will the squared playing feeld be? please enter a positive number: ");
		int sizeInput = myScanner.nextInt();
		
		int[][] playingField = createPlayingField(sizeInput);
		snailPath(playingField);
	}
	
	private static int[][] createPlayingField(int numberOfActions) {
		int[][] temp = new int[numberOfActions][numberOfActions];
		
		for (int rows = 0; rows < numberOfActions; rows++) {
			for (int column = 0; column < numberOfActions; column++) {
				temp[rows][column] = (column + 1 + (rows * 3));
			}
		}
		return temp;
	}
	
	private static void snailPath (int[][] playingField) {
		int rowLength = playingField.length - 1;
		for (int circleCount = 0; circleCount * 2 <= rowLength; circleCount++) {
			for (int i = 0; i + circleCount <= rowLength ; i++) {
				System.out.println(playingField[circleCount][i + circleCount]);
			}
			for (int i = 1; i + circleCount <= rowLength; i++) {
				System.out.println(playingField[i][rowLength]);
			}
			for (int i = rowLength; i + circleCount > circleCount; i--) {
				System.out.println(playingField[rowLength][i-1]);
			}
			for (int i = rowLength - 1; i + circleCount > circleCount; i--) {
				System.out.println(playingField[i][circleCount]);
			}
		}
	}
}