package coursework1;

import java.util.ArrayList;

class Observatory {
    String nameOfTheObservatory;
    private String locationOfTheCountry;
    private int startYearOfTheEarthquakeObservation;
    private double areaCovered;
    private ArrayList<Earthquake> earthquakeEvents = new ArrayList<>();
//    Earthquake myEarthquake;

    /**
     * initialize all the variables
     * @param _nameOfTheObservatory the name of the observatory
     * @param _locationOfTheCountry the name of the country in which it is located
     * @param _startYearOfTheEarthquakeObservation the year in which earthquake observations started
     * @param _areaCovered the area covered by the observatory (in square kilometres)
     * //@param _earthquakeEvents a list of Earthquake events that it has recorded.
     */
    Observatory(String _nameOfTheObservatory, String _locationOfTheCountry,
                int _startYearOfTheEarthquakeObservation, double _areaCovered) {
        nameOfTheObservatory = _nameOfTheObservatory;
        locationOfTheCountry = _locationOfTheCountry;
        startYearOfTheEarthquakeObservation = _startYearOfTheEarthquakeObservation;
        areaCovered = _areaCovered;
        //earthquakeEvents = _earthquakeEvents;
    }

    void addEvent(Earthquake myEarthquake) {
        earthquakeEvents.add(myEarthquake);
    }

    String  getTheNameOfTheObservatory() {
        return nameOfTheObservatory;
    }

    String  getTheLocationOfTheCountry() {
        return locationOfTheCountry;
    }

    int getTheStartYearOfTheEarthquakeObservation() {
        return startYearOfTheEarthquakeObservation;
    }

    double getTheAreaCovered() {
        return areaCovered;
    }

//    public ArrayList<Earthquake> getTheEarthquakeEvents() {
//        return earthquakeEvents;
//    }

    ArrayList<Earthquake> getTheLargestMagnitudeEarthquake() {
        double maximum = 0;
        int index = 0;
        ArrayList<Earthquake> maximumMagnitudeList = new ArrayList<>();
        //TODO: the situation when array is empty
        if (earthquakeEvents.size() == 0) {
            Earthquake emptyEarthquake = new Earthquake();
            emptyEarthquake.setMagnitude(-65535);
            maximumMagnitudeList.add(emptyEarthquake);
            return  maximumMagnitudeList;
        }
        for(int i = 0; i<earthquakeEvents.size(); i++) {
            double temp = earthquakeEvents.get(i).getMagnitude();
            if (temp > maximum) {
                index = i;
                maximum = temp;
            }
        }
        maximumMagnitudeList.add(earthquakeEvents.get(index));
        //TODO: the situation when 2 events share the 1st place
        for(int i = 0; i<earthquakeEvents.size(); i++) {
            double temp = earthquakeEvents.get(i).getMagnitude();
            if (temp == maximum) {
                maximumMagnitudeList.add(earthquakeEvents.get(i));
            }
        }
        return  maximumMagnitudeList;
    }

    double getTheAverageMagnitude() {
        double sum = 0;
        for (Earthquake earthquakeEvent : earthquakeEvents) {
            double temp = earthquakeEvent.getMagnitude();
            sum += temp;
        }
        return  sum/earthquakeEvents.size();
    }

    ArrayList<Earthquake> getMagnitudeAboveTheThreshold(double threshold) {
        ArrayList<Earthquake> indexArray = new ArrayList<>();
        for (Earthquake earthquakeEvent : earthquakeEvents) {
            double temp = earthquakeEvent.getMagnitude();
            if (temp > threshold) {
                indexArray.add(earthquakeEvent);
            }
        }
        return indexArray;
    }
}
