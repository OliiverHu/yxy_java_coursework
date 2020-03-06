package coursework2020;

public class Module {
    private String courseName;
    private String courseCode;
    private double credits;

    Module (String cName, String cCode, double c) {
        this.courseName = cName;
        this.courseCode = cCode;
        this.credits = c;
    }

    double getCredits () {
        return this.credits;
    }

    public String toString() {
        return this.courseName + ", " + this.courseCode + ", " + this.credits;
    }
}