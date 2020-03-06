package coursework2020;

public class Name {
    private String fisrtName;
    private String lastName;

    Name (String f, String l) {
        this.fisrtName = f;
        this.lastName = l;
    }

    public String getInitials() {
        return this.fisrtName.charAt(0) + "" + this.lastName.charAt(0);
    }

    String getFisrtName() {
        return fisrtName;
    }

    String getLastName() {
        return lastName;
    }

    public String toString() {
        return this.fisrtName + " " + this.lastName;
    }
}
