package contacts;

import java.time.LocalDate;
import java.util.Scanner;

public class Person extends Contact {

    private String firstName = "[no data]";
    private String lastName = "[no data]";
    private String gender = "[no data]";
    private LocalDate birthDate;

    //Getters & Setters
    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        setLastEdit();
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        setLastEdit();
        return this;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender.toUpperCase().equals("M") || gender.toUpperCase().equals("F")) {
            this.gender = gender.toUpperCase();
            setLastEdit();
        } else System.out.println("Bad gender!");
    }

    public String getBirthDate() {
        if (birthDate == null) return "[no data]";
        else return birthDate.toString();
    }

    public Person setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        setLastEdit();
        return this;
    }

    public Person setBirthdate(String birthdate) {
        try {
            setBirthDate(LocalDate.parse(birthdate));
        } catch (Exception e) {
            this.birthDate = null;
            System.out.println("Bad birth date!");
        }
        return this;
    }

    //Constructor(s)
    public Person() {
        super();
    }

    //Methods
    public String toString() {
        return "Name: " + getFirstName()
                + "\nSurname: " + getLastName()
                + "\nBirth date: " + getBirthDate()
                + "\nGender: " + getGender()
                + "\nNumber: " + getPhoneNumber()
                + "\nTime created: " + getCreated()
                + "\nTime last edit: " + getLastEdit();
    }

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a field (" + contactFields() + "):");
        String editField = scanner.nextLine();
        System.out.print("Enter " + editField + ": ");
        String newValue = scanner.nextLine();
        editField(editField, newValue);
    }

    @Override
    void editField(String field, String newValue) {
        switch (field) {
            case "name":
                setFirstName(newValue);
                break;
            case "surname":
                setLastName(newValue);
                break;
            case "birthdate":
                setBirthdate(newValue);
                break;
            case "gender":
                setGender(newValue);
                break;
            case "number":
                setPhoneNumber(newValue);
                break;
            default:
                System.out.println("Invalid field");
        }
    }

    @Override
    String getFieldValue(String field) {
        switch (field) {
            case "name":
                return getFirstName();
            case "surname":
                return getLastName();
            case "birthdate":
                return getBirthDate();
            case "gender":
                return getGender();
            case "number":
                return getPhoneNumber();
            default:
                return "Invalid field";
        }
    }

    @Override
    public String contactFields() {
        return "name, surname, birthdate, gender, number";
    }

    @Override
    String allFieldsConcat() {
        return getFirstName()+getLastName()+getBirthDate()+getGender()+getPhoneNumber();
    }
}
