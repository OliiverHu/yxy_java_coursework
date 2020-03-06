package coursework2020;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

public final class SmartCardNumber {
    private static final HashMap<String, SmartCardNumber> cardId = new HashMap<>();

    private String initialComponent;
    private int yearComponent;
    private String randomIntegerComponent;
    private String stringRep;

    private SmartCardNumber(String iniComp, int yearComp, String randIntComp) {
        this.initialComponent = iniComp;
        this.yearComponent = yearComp;
        this.randomIntegerComponent = randIntComp;
        this.stringRep = setStringRep();
    }

    private String setStringRep() {
        return this.initialComponent + "-" + this.yearComponent + "-" + this.randomIntegerComponent;
    }

    public static SmartCardNumber getCardNumber(Name studentName, Calendar issueDate) {
        Random roll = new Random();
        String n = "" + roll.nextInt(1000);

        String initials = studentName.getInitials();

        int year = issueDate.get(Calendar.YEAR);

        String s = initials + "-" + year + "-" + n;

        if (cardId.get(s) == null) {
            cardId.put(s, new SmartCardNumber(initials, year, n));
            return new SmartCardNumber(initials, year, n);
        }
        else {
            return getCardNumber(studentName, issueDate);
        }
        //return new StudentID(cComponent, nComponent, )
    }

    public String getInitialComponent() {
        return initialComponent;
    }

    public int getYearComponent() {
        return yearComponent;
    }

    public String getRandomIntegerComponent() {
        return randomIntegerComponent;
    }

    public String getStringRep() {
        return stringRep;
    }
}
