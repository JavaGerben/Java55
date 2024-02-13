public class NoTriples {
	public static void main (String[] args) {
		int[] dataSet1 = {1, 1, 1, 2, 2, 3, 5};
		int[] dataSet2 = {1, 4, 1, 2, 4, 3, 4};
		int[] dataSet3 = {2, 1, 5, 2, 2, 2, 5};
		int[] dataSet4 = {3, 1, 6, 2, 1, 3, 5};
		
		System.out.println (noTriples(dataSet1));
		System.out.println (noTriples(dataSet2));
		System.out.println (noTriples(dataSet3));
		System.out.println (noTriples(dataSet4));
		System.out.println (noTriples(1, 1, 1, 2, 1, 3, 5));
	}
	
	private static boolean noTriples (int... dataSet) {
		for (int i = 0; i < dataSet.length; i++) {
			if (i >= 2 && dataSet[i] == dataSet[i - 1] && dataSet[i] == dataSet[i - 2]) return true;
		}
		return false;
	}
}