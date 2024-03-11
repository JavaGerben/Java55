import java.util.*;

public class Challenge41 {
	public static void main(String[] args) {
		Coordinates coordinate1 = newCoordinate();
		Coordinates coordinate2 = newCoordinate();
		
		System.out.println (compare(coordinate1, coordinate2));
	}
	
	static Coordinates newCoordinate () {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Please enter a coordinate with a space inbetween X and Y.");
		String[] coordinatesIn = myScanner.nextLine().split(" ");
	
		Coordinates coordinate = new Coordinates(Integer.valueOf(coordinatesIn[0]), Integer.valueOf(coordinatesIn[1]));
		return coordinate;
	}
	
	static boolean compare (Coordinates coordinate1, Coordinates coordinate2) {
		if (coordinate1.X() == coordinate2.X()) {
			if (coordinate1.Y() == coordinate2.Y()-1 || coordinate1.Y() == coordinate2.Y()+1) {
				return true;
			}
		}
		if (coordinate1.Y() == coordinate2.Y()) {
			if (coordinate1.X() == coordinate2.X()-1 || coordinate1.X() == coordinate2.X()+1) {
				return true;
			}
		}
		return false;
	}
}

public record Coordinates (int X, int Y) { }