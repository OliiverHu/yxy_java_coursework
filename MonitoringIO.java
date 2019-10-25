package coursework1;

import java.util.ArrayList;
import java.util.Scanner;

public class MonitoringIO {
    private Monitoring myMonitors = new Monitoring(); // = new ArrayList<Monitoring>();

    private void startMenu() {
        Scanner startMenuScanner = new Scanner(System.in);
        System.out.println("1: Enter observatory data");
        System.out.println("2: Enter earthquake data");
        System.out.println("3: Provide all monitoring statistics");
        System.out.println("4: Exit");
        System.out.println("\n");
        //System.out.println("");
        //System.out.println("");
        int choice = startMenuScanner.nextInt();
        while (choice != 4) {
            if (choice == 1) {
                menuOne();
            }
            else if (choice == 2) {
                menuTwo();
            }
            else if (choice == 3) {
                menuThree();
            }
            else {
                warning();
            }
        }
    }

    private void menuOne() {
        Scanner menuOneScanner = new Scanner(System.in);
        System.out.println("Please Enter Observatory Data");

        System.out.println("Name of the Ob");
        String name = menuOneScanner.nextLine();

        System.out.println("location of the country");
        String loc = menuOneScanner.nextLine();

        System.out.println("start year");
        int year = menuOneScanner.nextInt();

        System.out.println("area covered");
        double area = menuOneScanner.nextDouble();

        Observatory myOb = new Observatory(name, loc, year, area);
        myMonitors.addObservatory(myOb);

        System.out.println("what ya gonna do next?");
        System.out.println("press 1 to continue");
        System.out.println("press 2 then back to the start menu");
        int menuOneChoice = menuOneScanner.nextInt();
        if (menuOneChoice == 1) {
            menuOne();
        }
        else {
            startMenu();
        }
    }

    private void menuTwo() {
        Scanner menuTwoScanner = new Scanner(System.in);
        System.out.println("Please Enter Earthquake Data");

        if (myMonitors.myObservatories.size() == 0) {
            System.out.println("No Observatories Documented!");
            startMenu();
        }
        else {
            System.out.println("Enter the Name of the Observatory");
            String nameOfOb = menuTwoScanner.nextLine();
            int indexOfOb = -1;
            for (int i = 0; i<myMonitors.myObservatories.size(); i++) {
                if (myMonitors.myObservatories.get(i).nameOfTheObservatory.equals(nameOfOb)) {
                    indexOfOb = i;
                }
            }
            if (indexOfOb == -1) {
                System.out.println("THIS Observatory has not been Documented yet!");
                System.out.println("Please double check the name you type in");
                System.out.println("\n");
                System.out.println("Press any key to proceed...");
                int waitKey = menuTwoScanner.nextInt();
                startMenu();
            }
            Earthquake tempEarthquake = new Earthquake();

            System.out.println("magnitude of the earthquake");
            double magnitude = menuTwoScanner.nextDouble();

            System.out.println("position of the earthquake");
            System.out.println("latitude of the earthquake");
            double latitude = menuTwoScanner.nextDouble();
            System.out.println("longitude of the earthquake");
            double longitude = menuTwoScanner.nextDouble();

            System.out.println("year of the event");
            int yearOfTheEvent = menuTwoScanner.nextInt();

            tempEarthquake.setMagnitude(magnitude);
            tempEarthquake.setYearOfTheEvent(yearOfTheEvent);
            tempEarthquake.setPosition(latitude, longitude);
            myMonitors.myObservatories.get(indexOfOb).addEvent(tempEarthquake);

            System.out.println("what ya gonna do next?");
            System.out.println("press 1 to continue");
            System.out.println("press 2 then back to the start menu");
            int menuTwoChoice = menuTwoScanner.nextInt();
            if (menuTwoChoice == 1) {
                menuTwo();
            }
            else {
                startMenu();
            }
        }
    }

    private void menuThree() {
        Scanner menuThreeScanner = new Scanner(System.in);
        System.out.println("Provide all monitoring statistics");
        System.out.println("Please enter a threshold for filtering out recorded earthquakes");
        double threshold = menuThreeScanner.nextDouble();

        System.out.println("1: The observatory with the largest average earthquake magnitude:");
        System.out.println("Name: " + myMonitors.getTheObservatoryWithTheLargestAverageMagnitude().getTheNameOfTheObservatory());
        System.out.println("Location: " + myMonitors.getTheObservatoryWithTheLargestAverageMagnitude().getTheLocationOfTheCountry());
        System.out.println("Start Year: " + myMonitors.getTheObservatoryWithTheLargestAverageMagnitude().getTheStartYearOfTheEarthquakeObservation());
        System.out.println("Area Covered: " + myMonitors.getTheObservatoryWithTheLargestAverageMagnitude().getTheAreaCovered());
        System.out.println('\n');

        System.out.println("2: The largest magnitude earthquake ever recorded:");
        System.out.println("Magnitude: " + myMonitors.getTheLargestMagnitudeEarthquake().getMagnitude());
        System.out.println("Position(latitude, longitude): (" + myMonitors.getTheLargestMagnitudeEarthquake().getPosition().getLatitude() + ", " + myMonitors.getTheLargestMagnitudeEarthquake().getPosition().getLongitude() + ")");
        System.out.println("Year of the Earthquake: " + myMonitors.getTheLargestMagnitudeEarthquake().getYearOfTheEvent());
        System.out.println('\n');

        System.out.println("3: earthquakes recorded with magnitude greater than " + threshold + ":");
        ArrayList<Earthquake> earthquakeOut = myMonitors.getAllEarthquakesWithMagnitudeAboveTheThreshold(threshold);
        for (Earthquake earthquake : earthquakeOut) {
            System.out.println("Magnitude: " + earthquake.getMagnitude());
            System.out.println("Position(latitude, longitude): (" + earthquake.getPosition().getLatitude() + ", " + earthquake.getPosition().getLongitude() + ")");
            System.out.println("Year of the Earthquake: " + earthquake.getYearOfTheEvent());
        }
        System.out.println('\n');

        System.out.println("Press any key to proceed...");
        int menuThreeChoice = menuThreeScanner.nextInt();
        startMenu();
    }

    private void warning() {
        Scanner warningScanner = new Scanner(System.in);
        System.out.println("Warning");
        System.out.println("Please type in a number between 1-4");
        System.out.println("\n");
        System.out.println("Press any key to proceed...");
        int warningChoice = warningScanner.nextInt();
        startMenu();
    }

    public static void main(String[] args) {
        //sc.useDelimiter("/n");
        MonitoringIO myIO = new MonitoringIO();
        myIO.startMenu();
    }
}
