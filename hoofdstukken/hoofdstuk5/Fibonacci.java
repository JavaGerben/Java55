import java.util.HashMap;

public class Fibonacci {
	static HashMap<Integer, Integer> previous = new HashMap<>();
	public static void main (String[] args) {
		System.out.println(fibonacci(48));
	}
	
	private static int fibonacci(int n) {
		if ( n < 2) {
			return n;
		}
		
		if (previous.containsKey(n)) {
			return previous.get(n);
		}
		
		int value = fibonacci(n-1) + fibonacci(n-2);
		previous.put(n, value);
		
		return value;
	}
}