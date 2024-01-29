public class Challenge6 {
	public static void main(String[] args) {
		byte myByte = 127;
		short myShort = 32767;
		int myInt = 2147483647;
		long myLong = 9223372036854775807L;
		float myFloat = 1.1234567f;
		double myDouble = 1.123456789101113;
		char myChar = 'a';
		boolean myBoolean = true;
		String myString = "you can type something in a string";
		
		System.out.println("this is the max number you can store in byte: " + myByte);
		System.out.println("this is the max number you can store in short: " + myShort);
		System.out.println("this is the max number you can store in int: " + myInt);
		System.out.println("this is the max number you can store in long: " + myLong);
		System.out.println("this is the max number you can store in float: " + myFloat);
		System.out.println("this is the max number you can store in double: " +myDouble);
		System.out.println("this is an example what a char can store: " + myChar);
		System.out.println("this is an example what a boolean can store: " + myBoolean);
		System.out.println("this is an example what a String can store: " + myString);
	}
}