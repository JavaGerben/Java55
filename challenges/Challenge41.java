import java.util.*;

public class Challenge41 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Input how big of a grid you want:");
		int gridSize = myScanner.nextInt();
		Coordinates grid = new Coordinates(gridSize);
		
		System.out.println(grid.getCoordinates());
		
	}
}

public class Coordinates {
	private HashMap<Integer, Integer> coordinates = new HashMap<>();
	
	public Coordinates (int gridSize) {
		for (int rows = 0; rows < gridSize; rows++) {
			for (int coloms = 0; coloms < gridSize; coloms++) {
				System.out.println(rows + " " + coloms);
			}
		}
	}
	
	public HashMap getCoordinates() {
		return coordinates;
	}
}