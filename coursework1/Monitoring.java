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

    ArrayList<Earthquake> getTheLargestMagnitudeEarthquake() {
        double mag = 0;
        ArrayList<Earthquake> largestEarthquake = new ArrayList<>();
        for (Observatory myObservatory : myObservatories) {
            ArrayList<Earthquake> temp = myObservatory.getTheLargestMagnitudeEarthquake();
            if (temp.get(0).getMagnitude() == -65535) {
                //TODO: skip to next loop
                continue;
                //System.out.println(1);
            }
            //for (int i = 0; i<temp.size(); i++) {
            if (temp.get(0).getMagnitude() > mag) {
                mag = temp.get(0).getMagnitude();
                largestEarthquake = temp;
            }
            //}
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
