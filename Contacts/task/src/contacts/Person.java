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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        setLastEdit();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        setLastEdit();
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

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        setLastEdit();
    }

    public void setBirthdate(String birthdate) {
        try {
            setBirthDate(LocalDate.parse(birthdate));
        } catch (Exception e) {
            this.birthDate = null;
            System.out.println("Bad birth date!");
        }
    }

    //Constructor
    public Person(String firstName, String lastName, String gender, String birthDate, String phoneNumber) {
        super(phoneNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        setBirthdate(birthDate);
    }

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
    public String returnName() {
        return firstName + " " + lastName;
    }

    @Override
    public void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a field (name, surname, birth, gender, number): ");
        String editField = scanner.nextLine();

        switch (editField) {
            case "name":
                System.out.print("Enter name: ");
                setFirstName(scanner.nextLine());
                break;
            case "surname":
                System.out.print("Enter surname: ");
                setLastName(scanner.nextLine());
                break;
            case "birth":
                System.out.print("Enter birthdate: ");
                setBirthdate(scanner.nextLine());
                break;
            case "gender":
                System.out.print("Enter gender: ");
                setGender(scanner.nextLine());
                break;
            case "number":
                System.out.print("Enter number: ");
                setPhoneNumber(scanner.nextLine());
                break;
            default:
                System.out.println("Invalid Field!");
        }
    }
}
