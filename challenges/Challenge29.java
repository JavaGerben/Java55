package challenges;

public class Challenge29 {
	public static void main (String[] args) {
		Color option1 = new Color(255, 255, 255);
		System.out.println(option1.getColor());
		
		Color option2 = new Color("green");
		System.out.println(option2.getColor());
	}
}

class Color {
	private int redValue;
	private int greenValue;
	private int blueValue;
	private String color;
	
	final static String white = "White (255, 255, 255)";
	final static String black = "Black (0, 0, 0)";
	final static String red = "Red (255, 0, 0)";
	final static String orange = "Orange (255,165, 0)";
	final static String yellow = "Yellow (255, 255, 0)";
	final static String green = "Green (0, 128, 0)";
	final static String blue = "Blue (0, 0, 255)";
	final static String purple = "Purple (128, 0, 128)";
	
	
	public Color (int redValue, int greenValue, int blueValue) {
		this.redValue = redValue;
		this.greenValue = greenValue;
		this.blueValue = blueValue;
		color = "(" + redValue + ", " + greenValue + ", " + blueValue + ")";
	}
	
	public Color (String colorName) {
		color = switch(colorName.toLowerCase()) {
			case "white" 	-> white;
			case "black" 	-> black;
			case "red" 		-> red;
			case "orange" 	-> orange;
			case "yellow" 	-> yellow;
			case "green" 	-> green;
			case "blue" 	-> blue;
			case "purple" 	-> purple;
			default			-> null;
		};
	}
	
	public String getColor() {
		return color;
	}
}

//ik denk dat dit de opdracht was. maar ik vond het niet duidelijk uitgelegd. dit werkt in ieder geval ^^