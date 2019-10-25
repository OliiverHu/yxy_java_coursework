package coursework1;

import java.util.Scanner;

/**
 * This test case is built to test all the set and get method in
 * Class Earthquake
 */
public class EarthquakeTest {
    public static void main(String[] args) {
        System.out.println("--------------------");
        System.out.println("Earthquake Test Case");
        System.out.println("--------------------");
        System.out.println('\n');

        //create a scanner to receive keyboard input
        Earthquake myEarthquakeTestCase = new Earthquake();
        Scanner earthquakeTestScanner = new Scanner(System.in);

        //get the magnitude, position and time that associates with the earthquake event
        double mag = earthquakeTestScanner.nextDouble();
        myEarthquakeTestCase.setMagnitude(mag);

        double _latitude = earthquakeTestScanner.nextDouble();
        double _longitude = earthquakeTestScanner.nextDouble();
        myEarthquakeTestCase.setPosition(_latitude, _longitude);

        int yearOfTheEvent = earthquakeTestScanner.nextInt();
        myEarthquakeTestCase.setYearOfTheEvent(yearOfTheEvent);

        //output all the information we just type in
        double magOut = myEarthquakeTestCase.getMagnitude();
        double lati = myEarthquakeTestCase.getPosition().getLatitude();
        double longi = myEarthquakeTestCase.getPosition().getLongitude();
        int yearOut = myEarthquakeTestCase.getYearOfTheEvent();
        System.out.println("---------------------");
        System.out.println("What you just type in");
        System.out.println("---------------------");
        System.out.println("Magnitude: " + magOut);
        System.out.println("Position(latitude, longitude): (" + lati + ", " + longi + ")");
        System.out.println("Year: " + yearOut);
    }
}
