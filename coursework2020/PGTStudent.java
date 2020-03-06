package coursework2020;

import java.util.Calendar;

public class PGTStudent extends AbstractStudent {
    PGTStudent (String type, String fName, String lName, Calendar date) {
        super(type, fName, lName, date);
    }
//    PGTStudent (ArrayList courses, StudentID id) {
//        super(id);
//        super.modules = courses;
//        this.calculateCredits();
//    }
//
//    private void calculateCredits() {
//
//    }
//
//    public String getStudentType() {
//        return "PGT";
//    }
//
//    public ArrayList getModules() {
//        return modules;
//    }
//
//    public Boolean enoughCredits() {
//        return (credits >= 180);
//    }
}
