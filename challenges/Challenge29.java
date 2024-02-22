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
	private Color madeColors;
	private String color;
	
	
	final static Color white = new Color(255, 255, 255);
	final static Color black = new Color(0, 0, 0);
	final static Color red = new Color(255, 0, 0);
	final static Color orange = new Color(255,165, 0);
	final static Color yellow = new Color(255, 255, 0);
	final static Color green = new Color(0, 128, 0);
	final static Color blue = new Color(0, 0, 255);
	final static Color purple = new Color(128, 0, 128);
	
	
	public Color (int redValue, int greenValue, int blueValue) {
		this.redValue = redValue;
		this.greenValue = greenValue;
		this.blueValue = blueValue;
		color = "(" + redValue + ", " + greenValue + ", " + blueValue + ")";
	}
	
	public Color (String colorName) {
		madeColors = switch(colorName) {
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
		if (color == null) {
			return madeColors.getColor();
		} else {
			return color;
		}
	}
}