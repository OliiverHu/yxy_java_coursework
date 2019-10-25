package coursework1;

import java.util.ArrayList;

class Monitoring {
    ArrayList<Observatory> myObservatories = new ArrayList<>();
    Monitoring() {}

    void addObservatory(Observatory myOb) {
        myObservatories.add(myOb);
    }

    Observatory getTheObservatoryWithTheLargestAverageMagnitude() {
        double mag = 0;
        int index = 0;
        for (int i = 0; i<myObservatories.size(); i++) {
            double temp = myObservatories.get(i).getTheAverageMagnitude();
            if (temp > mag) {
                mag = temp;
                index = i;
            }
        }
        return myObservatories.get(index);
    }

    Earthquake getTheLargestMagnitudeEarthquake() {
        double mag = 0;
        Earthquake largestEarthquake = new Earthquake();
        for (Observatory myObservatory : myObservatories) {
            Earthquake temp = myObservatory.getTheLargestMagnitudeEarthquake();
//            if (temp == Null)
            if (temp.getMagnitude() > mag) {
                mag = temp.getMagnitude();
                largestEarthquake = temp;
            }
        }
        return largestEarthquake;
    }

    ArrayList<Earthquake> getAllEarthquakesWithMagnitudeAboveTheThreshold(double thres) {
        ArrayList<Earthquake> allEarthquakesAboveThreshold = new ArrayList<>();
        for (Observatory myObservatory : myObservatories) {
            ArrayList<Earthquake> temp = myObservatory.getMagnitudeAboveTheThreshold(thres);
            allEarthquakesAboveThreshold.addAll(temp);
        }
        return allEarthquakesAboveThreshold;
    }
}
