import java.util.Scanner;

public class SecondsToHourMinutesAndSeconds {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Please put in any amount of seconds.");
		int secondsTotal = myScanner.nextInt();
		
		
		int daysTime = secondsTotal / 86400;
		secondsTotal %= 86400;
		int hoursTime = secondsTotal / 3600;
		secondsTotal %= 3600;
		int minutesTime = secondsTotal / 60;
		int secondsTime = secondsTotal % 60;
		
		System.out.println(daysTime + " days and " + hoursTime + ":" + minutesTime + ":" + secondsTime);
	}
}