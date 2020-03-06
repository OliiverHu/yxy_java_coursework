package coursework2020;

import java.util.Calendar;

public class SmartCard {

    private Name studentName;
    private Calendar birthDate;
    private SmartCardNumber uniqueNumber;
    private Calendar issueDate;
    private String studentType;

    private Calendar expiryDate;

    SmartCard(AbstractStudent student, Calendar issueDate) {
        this.studentName = student.getStudentName();
        this.birthDate = student.getBirthDate();
        this.issueDate = issueDate;
        this.studentType = student.getStudentType();
        this.uniqueNumber = SmartCardNumber.getCardNumber(studentName, issueDate);
    }

    public Name getName() {
        return this.studentName;
    }

    public Calendar getBirthDate() {
        return this.birthDate;
    }

    public Calendar getIssueDate() {
        return this.issueDate;
    }

    public String getSmartCardNumber() {
        return this.uniqueNumber.toString();
    }

    private void setExpiryDate() {

        this.expiryDate.set(Calendar.MONTH, this.issueDate.get(Calendar.MONTH));
        this.expiryDate.set(Calendar.DATE, this.issueDate.get(Calendar.DATE));
        switch (this.studentType) {
            case "UG":
                this.expiryDate.set(Calendar.YEAR, this.issueDate.get(Calendar.YEAR) + 4);
                break;
            case "PGT":
                this.expiryDate.set(Calendar.YEAR, this.issueDate.get(Calendar.YEAR) + 2);
                break;
            case "PGR":
                this.expiryDate.set(Calendar.YEAR, this.issueDate.get(Calendar.YEAR) + 5);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public Calendar getExpiryDate() {
        Calendar expiryDate = Calendar.getInstance();
        expiryDate.set(this.expiryDate.get(Calendar.YEAR), this.expiryDate.get(Calendar.MONTH), this.expiryDate.get(Calendar.DATE));
        return expiryDate;
    }

    public void resetStudentName(String fName, String lName) {
        this.studentName = new Name(fName, lName);
    }

    public void resetBirthOfDate(int y, int m, int d) {
        this.birthDate.set(y, m, d);
    }
}
