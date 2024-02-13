public class Challenge21 {
	public static void main (String[] args) {
		int sumOf = 100;
		
		int  result = sum(sumOf);
		double result2 = sum2(sumOf);
		System.out.println(result + " " + result2);
	}
	public static int sum(int k) {
		if (k > 0) {
		  return k + sum(k - 1);
		} else {
		  return 0;
		}
	}
	
	//second methode without looping, less work to calc the sum
	public static double sum2(double k) {
		if (k > 1.0) {
			return (1 + k) / 2 * k;
		} else  if (k == 1.0) {
			return 1;
		} else {
			return 0;
		}
	}	
}