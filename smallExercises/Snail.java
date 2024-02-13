import java.util.Scanner;

public class Snail {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.print("how big will the squared playing feeld be? please enter a positive number: ");
		int sizeInput = myScanner.nextInt();
		
		int[][] playingField = createPlayingField(sizeInput);
		System.out.println("the playing field looks like this:");
		printPlayingField(playingField);
		System.out.println("the snail trail is:");
		snailPath(playingField);
	}
	
	private static int[][] createPlayingField(int numberOfActions) {
		int[][] temp = new int[numberOfActions][numberOfActions];
		
		for (int rows = 0; rows < numberOfActions; rows++) {
			for (int column = 0; column < numberOfActions; column++) {
				temp[rows][column] = (column + 1 + (rows * numberOfActions));
			}
			System.out.println();
		}
		return temp;
	}
	
	private static void printPlayingField(int[][] playingField){
		int fieldNumbers = 0;
		for (int rows = 0; rows < playingField.length; rows++) {
			for (int column = 0; column < playingField.length; column++) {
				fieldNumbers++;
				if (fieldNumbers < 10) {
					System.out.print("0" + fieldNumbers + " ");
				} else {
					System.out.print(fieldNumbers + " ");
				}
			}
			System.out.println();
		}
	}
	
	private static void snailPath (int[][] playingField) {
		int rowLength = playingField.length - 1;
		
		
		for (int circleCount = 0; circleCount * 2 <= rowLength; circleCount++) {
			
			//prints all lines from left to right
			for (int i = circleCount; i + circleCount <= rowLength; i++) {
				System.out.println(playingField[circleCount][i]);
			}
			
			//prints all lines from up to down
			for (int i = circleCount + 1; i + circleCount <= rowLength; i++) {
				System.out.println(playingField[i][rowLength - circleCount]);
			}
			
			//prints all lines from right to left
			for (int i = rowLength; i - circleCount > circleCount; i--) {
				System.out.println(playingField[rowLength - circleCount][i - circleCount - 1]);
			}
			
			//prints all lines from donw to up
			for (int i = rowLength - 1; i - circleCount > circleCount; i--) {
				System.out.println(playingField[i - circleCount][circleCount]);
			}
		}
	}
}