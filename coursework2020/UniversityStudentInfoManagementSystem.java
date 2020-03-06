package coursework2020;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class UniversityStudentInfoManagementSystem {
    private static UniversityStudentInfoManagementSystem INFO_MANAGEMENT_SYSTEM = null;

    private ArrayList<AbstractStudent> studentList = null;
    private ArrayList<Module> moduleList = null;
    private ArrayList<Name> supervisorList = null;

    public static UniversityStudentInfoManagementSystem getInstance() {
        if (INFO_MANAGEMENT_SYSTEM == null) {
            INFO_MANAGEMENT_SYSTEM = new UniversityStudentInfoManagementSystem();
        }

        return INFO_MANAGEMENT_SYSTEM;
    }

    private void setModuleList() throws FileNotFoundException {
        Scanner inFile = new Scanner(new FileReader("/Users/huyf/Desktop/java/src/coursework2020/module.txt"));
        while (inFile.hasNextLine()) {
            String line = inFile.nextLine();
            String[] stringList = line.split(",");
            Double credits = new Double(stringList[2]);
            Module m = new Module(stringList[1], stringList[0], credits);
            this.moduleList.add(m);
        }
    }

    private void setSupervisorList() throws FileNotFoundException {
        Scanner inFile = new Scanner(new FileReader("/Users/huyf/Desktop/java/src/coursework2020/supervisor.txt"));
        while (inFile.hasNextLine()) {
            String line = inFile.nextLine();
            String[] stringList = line.split(" ");
            //Double credits = new Double(stringList[2]);
            Name supervisor = new Name(stringList[0], stringList[1]);
            this.supervisorList.add(supervisor);
        }
    }

    public int getNumberOfStudents(String type) {
        int total = 0;
        for (AbstractStudent student: studentList) {
            if (student.getStudentType().equals(type)) {
                total += 1;
            }
        }
        return total;
    }

    public void registerStudent(AbstractStudent student) {
//        if (type.equals("PGR")) {
//            PGRStudent student = (PGRStudent) StudentFactory.registerStudent(type);
//        }
//        else if (type.equals("PGT")) {
//            PGTStudent student = (PGTStudent) StudentFactory.registerStudent(type);
//        }
//        els
//        AbstractStudent student = StudentFactory.registerStudent(type);
//        PGTStudent student1 = (PGTStudent) StudentFactory.registerStudent(type);
//        this.studentList.add(student1);
        this.studentList.add(student);
    }

    private void amendStudentData(AbstractStudent student, ArrayList<Module> newModuleList) {
        //implementing a perfect overloading of this method would be extremely complicated...
        student.resetModules(newModuleList);
    }

    private void amendStudentData(AbstractStudent student, String fName, String lName) {
        //implementing a perfect overloading of this method would be extremely complicated...
        student.resetName(fName, lName);
    }

    private void amendStudentData(AbstractStudent student, int year, int month, int date) {
        //implementing a perfect overloading of this method would be extremely complicated...
        student.resetBirthDate(year, month, date);
    }

    private void terminateStudent(String id) {
        //delete student id if possible
        //pop out student in the list
        for (AbstractStudent student: studentList) {
            String studentId = student.getStudentID();
            if (studentId.equals(id)) {
                StudentID.deleteID(id);
                studentList.remove(student);
                return;
            }
        }
        throw new IllegalStateException(); // this id has not been registered at all.
    }

    private void issueSmartCard(String id) {
        //undergrad >= 17
        //postgrad >= 20
        //each student can only have one card
        for (AbstractStudent student: studentList) {
            String studentId = student.getStudentID();
            if (studentId.equals(id)) {
                Calendar dateOfToday = Calendar.getInstance();
//                    dateOfToday.set(Calendar.HOUR_OF_DAY, 0);
                Calendar dateOfBirth = student.getBirthDate();
                if (dateOfBirth.after(dateOfToday)) {
                    throw new IllegalArgumentException("Can't be born in the future");
                }
                int year1 = dateOfToday.get(Calendar.YEAR);
                int year2 = dateOfBirth.get(Calendar.YEAR);
                int age = year1 - year2;
                int month1 = dateOfToday.get(Calendar.MONTH);
                int month2 = dateOfBirth.get(Calendar.MONTH);
                if (month2 > month1) {
                    age--;
                } else if (month1 == month2) {
                    int day1 = dateOfToday.get(Calendar.DAY_OF_MONTH);
                    int day2 = dateOfBirth.get(Calendar.DAY_OF_MONTH);
                    if (day2 > day1) {
                        age--;
                    }
                }
                if (age >= 20) {
                    SmartCard Card = new SmartCard(student, dateOfToday);
                    try {
                        student.setSmartCard(Card);
                    } catch (Exception IllegalStateException) {
                        IllegalStateException.printStackTrace();
                    }
                }
                else if (student.getStudentType().equals("UG") && age >= 17) {
                    SmartCard Card = new SmartCard(student, dateOfToday);
                    try {
                        student.setSmartCard(Card);
                    } catch (Exception IllegalStateException) {
                        IllegalStateException.printStackTrace();
                    }
                }
                else {
                    System.out.println("not old enough to get a smart card");
                }
            }
        }
    }

    private boolean isCorrectlyRegistered(AbstractStudent student) {
        if (!student.getStudentType().equals("PGR")) {
            return student.enoughCredits();
        }
        PGRStudent student1 = (PGRStudent) student;
        return student1.enoughCredits() && student1.getSupervisor() != null;
    }
}
