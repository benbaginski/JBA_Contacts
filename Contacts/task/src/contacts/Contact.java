package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean hasNumber() {
        return phoneNumber.compareTo("") != 0;
    }

    public String getPhoneNumber() {
        return hasNumber() ? phoneNumber : "[no number]";
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isValidPhoneNumber(phoneNumber)) this.phoneNumber = phoneNumber;
        else {
            System.out.println("Wrong number format!");
            this.phoneNumber = "";
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        //Group 1 has parens
        Pattern pattern = Pattern.compile("^(\\+)?(\\(\\w+\\))([ -]\\w{2,})*$");
        //Group 2 has parens
        Pattern pattern2 = Pattern.compile("^(\\+)?(\\w+)([ -]\\(\\w{2,}\\))([ -]\\w{2,})*$");
        //No paren groups
        Pattern pattern3 = Pattern.compile("^(\\+)?(\\w+)([ -]\\w{2,})*$");
        Matcher matcher = pattern.matcher(phoneNumber);
        Matcher matcher2 = pattern2.matcher(phoneNumber);
        Matcher matcher3 = pattern3.matcher(phoneNumber);

        //If only one of the patterns matches, but not all.
        return matcher.find() ^ matcher2.find() ^ matcher3.find();
    }

    public Contact(String firstName, String lastName, String phoneNumber) {
        setLastName(lastName);
        setFirstName(firstName);
        setPhoneNumber(phoneNumber);
    }

    public String toString() {
        return getFirstName() + " " + getLastName() + ", " + getPhoneNumber();
    }


}
