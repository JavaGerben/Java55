package challenges;

public class Challenge28 {
	public static void main (String[] args) {
		Point firstPoint = new Point(2, 3);
		Point secondPoint = new Point(-4, 0);
		
		System.out.println("(x" + firstPoint.getX() + ", y" + firstPoint.getY() + ")");
		System.out.println("(x" + secondPoint.getX() + ", y" + secondPoint.getY() + ")");
	}
}

class Point {
	private int x;
	private int y;
	
	public Point() {
		x = 0;
		y = 0;
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX () {
		return x;
	}
	
	public int getY () {
		return y;
	}
}

/* "Answer this question: Are your x and y immutable? Why did you choose what you did?"
 * Yes they are immutable, because the int's are private and they have no setters.
 * x and y can only be defined when creating a point.
 */