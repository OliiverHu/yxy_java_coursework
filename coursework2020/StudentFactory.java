package coursework2020;

import java.util.Calendar;

public class StudentFactory {
    public static AbstractStudent registerStudent(String studentType, String fName, String lName, int year, int month, int date) {
//        AbstractStudent student;
        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(year, month, date);

        switch (studentType) {
            case "UG":
                return new UGStudent(studentType, fName, lName, dateOfBirth);
            case "PGT":
                return new PGTStudent(studentType, fName, lName, dateOfBirth);
            case "PGR":
                return new PGRStudent(studentType, fName, lName, dateOfBirth);
            default:
                throw new IllegalArgumentException();
                //return null; //new NullStudent("null");
        }
    }
}
