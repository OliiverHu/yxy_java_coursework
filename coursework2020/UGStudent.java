package coursework2020;

import java.util.Calendar;

public class UGStudent extends AbstractStudent {
    UGStudent (String type, String fName, String lName, Calendar date) {
        super(type, fName, lName, date);
    }
//    UGStudent (ArrayList courses, StudentID id) {
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
//        return "UG";
//    }
//
//    public ArrayList getModules() {
//        return modules;
//    }
//
//    public Boolean enoughCredits() {
//        return (credits >= 120);
//    }
}
