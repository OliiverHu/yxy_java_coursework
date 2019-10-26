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
        try {
            System.out.println("Magnitude:");
            double mag = earthquakeTestScanner.nextDouble();
            System.out.println("Latitude:");
            double _latitude = earthquakeTestScanner.nextDouble();
            System.out.println("Longitude:");
            double _longitude = earthquakeTestScanner.nextDouble();
            System.out.println("Year:");
            int yearOfTheEvent = earthquakeTestScanner.nextInt();

            myEarthquakeTestCase.setMagnitude(mag);
            myEarthquakeTestCase.setPosition(_latitude, _longitude);
            myEarthquakeTestCase.setYearOfTheEvent(yearOfTheEvent);
        }
        catch (Exception e) {
            System.out.println("输入有误！");
            return;
        }

        //output all the information we just type in
        double magOut = myEarthquakeTestCase.getMagnitude();
        int yearOut = myEarthquakeTestCase.getYearOfTheEvent();
        System.out.println("---------------------");
        System.out.println("What you just type in");
        System.out.println("---------------------");
        System.out.println("Magnitude: " + magOut);
        myEarthquakeTestCase.getPosition().printPosition();
        System.out.println("Year: " + yearOut);
    }
}
