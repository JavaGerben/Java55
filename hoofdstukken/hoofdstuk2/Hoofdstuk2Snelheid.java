import java.util.Scanner;

public class Hoofdstuk2Snelheid {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.print("Invoerafstand in meters: ");
		double meters = myScanner.nextDouble();
		System.out.print("Invoeruur: ");
		double hours = myScanner.nextDouble();
		System.out.print("Invoerninuten: ");
		double minutes = myScanner.nextDouble();
		System.out.print("Invoer seconden: ");
		double seconds = myScanner.nextDouble();
		System.out.println();
		
		double totalSeconds = seconds + (minutes * 60) + (hours * 3600);
		double totalHours = hours + (minutes / 60) + (seconds / 3600);
		
		double meterPerSecond = meters / totalSeconds;
		double kmPerHour = (meters / 1000) / totalHours;
		double mijlPerHour = (meters / 1609) / totalHours;
		
		System.out.println("Uw snelheid in meter/seconde is: " + meterPerSecond);
		System.out.println("Uw snelheid in km/u is: " + kmPerHour);
		System.out.println("Uw snelheid in mijl/u is: " + mijlPerHour);
	}
}