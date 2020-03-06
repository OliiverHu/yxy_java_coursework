package coursework2020;

import java.util.HashMap;
import java.util.Random;

public final class StudentID {
    private static final HashMap<String, StudentID> studentId = new HashMap<String, StudentID>();
//    private static final int serialNumber = 0;
//    private static final char serialChar = 'a';
    private final char characterComponent;
    private final String serialNumberComponent, strRep;

    private StudentID(char characterComponent, String serialNumberComponent) {
        this.characterComponent = characterComponent;
        this.serialNumberComponent = serialNumberComponent;
        this.strRep = setStringRep();
    }

    private String setStringRep() {
        return this.characterComponent + this.serialNumberComponent;
    }

//    private char setCharacterComponent() {
//
//    }
//
//    private String setSerialNumberComponent() {
//        Random roll = new Random();
//        int number1 = roll.nextInt(10);
//        int number2 = roll.nextInt(10);
//        int number3 = roll.nextInt(10);
//        int number4 = roll.nextInt(10);
//        return number1 + "" + number2 + number3 + number4;
//    }
//
//    private boolean isIdUnique(String stringRep) {
//        return ;
//    }

    public static StudentID getID() {
        Random roll = new Random();
        int n = roll.nextInt(26);
        //return (char) (n + 'a');
        char c = (char) (n + 'a');

        //Random roll2 = new Random();
        int number1 = roll.nextInt(10);
        int number2 = roll.nextInt(10);
        int number3 = roll.nextInt(10);
        int number4 = roll.nextInt(10);
        String s = number1 + "" + number2 + number3 + number4;

        if (studentId.get(c + s) == null) {
            studentId.put(c + s, new StudentID(c, s));
            return new StudentID(c, s);
        }
        else {
            return getID();
        }
        //return new StudentID(cComponent, nComponent, )
    }

    public static void deleteID(String id) {
        if (studentId.get(id) != null) {
            studentId.remove(id, studentId.get(id));
        }
        else {
            System.out.println("error occurs!");
            //throw new IllegalStateException(); // this id might not be registered correctly
        }
    }

    public char getCharacterComponent() {
        return characterComponent;
    }

    public String getSerialNumberComponent() {
        return serialNumberComponent;
    }

    public String getStringRep() {
        return strRep;
    }
}

//public class StudentID {
//    private char component1;
//    private String component2;
//
//    StudentID (char comp1, String comp2) {
//        this.component1 = comp1;
//        this.component2 = comp2;
//    }
//
//    public static StudentID registerID () {
//        return new StudentID('a', "1234");
//    }
//
//    public char getComponent1() {
//        return component1;
//    }
//
//    public String getComponent2() {
//        return component2;
//    }
//
//    public String toString() {
//        return this.component1 + this.component2;
//    }
//
////    public String test() {
////        return this.component1 + this.component2;
////    }
//}

