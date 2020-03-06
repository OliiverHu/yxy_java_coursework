package coursework2020;

import java.util.Calendar;

public class PGRStudent extends AbstractStudent {
    private Name supervisor = null;

    PGRStudent (String type, String fName, String lName, Calendar date) {
        super(type, fName, lName, date);
    }

    public void setSupervisor(Name supervisor) {
        this.supervisor = supervisor;
    }

    public Name getSupervisor() {
        return this.supervisor;
    }

//    PGRStudent (ArrayList courses, StudentID id, Name s) {
//        super(id);
//        super.modules = courses;
//        this.calculateCredits();
//        this.supervisor = s;
//    }
//
//    private void calculateCredits() {
//
//    }
//
//    public String getStudentType() {
//        return "PGR";
//    }
//
//    public ArrayList getModules() {
//        return modules;
//    }
//
//    public Boolean enoughCredits() {
//        return (credits >= 0);
//    }
//
//    public Name getSupervisor() {
//        return new Name(this.supervisor.getFisrtName(), this.supervisor.getLastName());
//    }
}
