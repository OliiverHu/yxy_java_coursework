package coursework2020;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class AbstractStudent implements Student {
    private StudentID studentID;
    private Name studentName;
    private Calendar birthDate;

    private ArrayList<Module> modules = null;
    private SmartCard smartCard = null;
    private double credits;
    //private String supervisor;
    private String studentType;

    AbstractStudent (String type, String fName, String lName, Calendar date) {
        this.studentType = type;
        this.studentID = StudentID.getID();
        this.studentName = new Name(fName, lName);
        this.credits = 0;
        this.birthDate = date;
        this.modules = new ArrayList<>();
    }

    void addModule(Module m) {
        this.modules.add(m);
        this.credits += m.getCredits();
    }

    void setSmartCard(SmartCard card) {
        if (this.smartCard == null) {
            this.smartCard = card;
        }
        else {
            throw new IllegalStateException();
        }
    }

    public String getStudentID() {
//        char comp1 = this.studentID.getComponent1();
//        String comp2 = this.studentID.getComponent2();
//        StudentID returnStudentInstance = new StudentID(comp1, comp2);
        return this.studentID.getStringRep();
    }

//    private Name setSupervisor () {
//
//    }

    public String getStudentType() {
        return this.studentType;
    }

    public void printModules() {
        for (Module m: modules) {
            System.out.println(m);
        }
        //return (ArrayList<Module>) modules.clone();
        //return modules;
    }

    public void resetModules(ArrayList<Module> modules) {
        this.modules = null;
        for (Module m: modules) {
            this.addModule(m);
        }
    }

    public void resetName(String fName, String lName) {
        this.studentName = new Name(fName, lName);
        this.smartCard.resetStudentName(fName, lName);
    }

    public void resetBirthDate(int y, int m, int d) {
        //this.birthDate = Calendar.getInstance();
        this.birthDate.set(y, m, d);
        this.smartCard.resetBirthOfDate(y, m, d);
    }

    public Name getStudentName() {
        return new Name(this.studentName.getFisrtName(), this.studentName.getLastName());
    }

    public Calendar getBirthDate() {
        Calendar bDate = Calendar.getInstance();
        bDate.set(this.birthDate.get(Calendar.YEAR), this.birthDate.get(Calendar.MONTH), this.birthDate.get(Calendar.DATE));
        return bDate;
    }

    public boolean enoughCredits() {
        switch (this.studentType) {
            case "UG":
                return (this.credits >= 120);
            case "PGT":
                return (this.credits >= 180);
            case "PGR":
                return (this.credits >= 0);
            default:
                throw new IllegalArgumentException(); //new NullStudent("null");
        }
    }
}
