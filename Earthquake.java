package coursework1;

/**
 * Earthquake Class
 * @author Ollie
 * This class is built to store and retrieve information about the magnitude,
 * position (latitude and longitude)
 * and year of the event.
 */
class Earthquake {
    /**
     * Position Class
     * This class(struct) is built to return 2 values(latitude and longitude)
     */
    public static class Position {
        double latitude;
        double longitude;
        Position(double _latitude, double _longitude) {
            latitude = _latitude;
            longitude = _longitude;
        }
        double getLatitude() { return latitude; }
        double getLongitude() { return longitude; }
    }

    private double magnitude;
//    double latitude;
//    double longitude;
    private Position position;
    private int yearOfTheEvent;

    Earthquake() { }

    /**
     * manually set the value for variables magnitude
     * @param mag the input value of magnitude
     */
    void setMagnitude(double mag) {
        magnitude = mag;
    }

    /**
     * manually set the value for variables latitude and longitude
     * @param _latitude the input value of latitude
     * @param _longitude the input value of longitude
     */
    void setPosition(double _latitude, double _longitude) {
//        latitude = _latitude;
//        longitude = _longitude;
        position = new Position(_latitude, _longitude);
    }

    /**
     * manually set the value for variables of the year of the event
     * @param _yearOfTheEvent the input value of yearOfTheEvent
     */
    void setYearOfTheEvent(int _yearOfTheEvent) {
        yearOfTheEvent = _yearOfTheEvent;
    }

    /**
     * get the value of magnitude
     * @return return the value of magnitude
     */
    double getMagnitude() {
        return magnitude;
    }

    /**
     * get the value of longitude and latitude
     * @return return the value of longitude and latitude
     */
    Position getPosition() {
        return position;
    }

    /**
     * get the value of year of the event
     * @return return the value of yearOfTheEvent
     */
    int getYearOfTheEvent() {
        return yearOfTheEvent;
    }
}
