package contacts;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime created;
    private LocalDateTime lastEdit;
    private String phoneNumber;

    //Getters & Setters
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getLastEdit() {
        return lastEdit;
    }

    public void setLastEdit() {
        this.lastEdit = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
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

    //Constructors
    public Contact(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        this.created = LocalDateTime.now();
        setLastEdit();
    }

    public Contact() {
        this.created = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        setLastEdit();
    }

    //Concrete Methods
    public boolean hasNumber() {
        return phoneNumber.compareTo("") != 0;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        //Number Group 1 has parens
        Pattern pattern = Pattern.compile("^(\\+)?(\\(\\w+\\))([ -]\\w{2,})*$");
        //Number Group 2 has parens
        Pattern pattern2 = Pattern.compile("^(\\+)?(\\w+)([ -]\\(\\w{2,}\\))([ -]\\w{2,})*$");
        //No paren groups
        Pattern pattern3 = Pattern.compile("^(\\+)?(\\w+)([ -]\\w{2,})*$");
        Matcher matcher = pattern.matcher(phoneNumber);
        Matcher matcher2 = pattern2.matcher(phoneNumber);
        Matcher matcher3 = pattern3.matcher(phoneNumber);

        //If only one of the patterns matches, but not all.
        return matcher.find() ^ matcher2.find() ^ matcher3.find();
    }

    //Abstract Methods
    abstract void edit();

    abstract void editField(String field, String newValue);

    abstract String getFieldValue(String field);

    abstract String getFullName();

    abstract String contactFields();

    abstract String allFieldsConcat();
}
