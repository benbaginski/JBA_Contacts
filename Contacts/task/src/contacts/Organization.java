package contacts;

import java.util.Scanner;

public class Organization extends Contact {

    private String address = "[no data]";
    private String orgName = "[no data]";

    //Getters & Setters
    public String getAddress() {
        return address;
    }

    public Organization setAddress(String address) {
        this.address = address;
        setLastEdit();
        return this;
    }

    public String getOrgName() {
        return orgName;
    }

    public Organization setOrgName(String orgName) {
        this.orgName = orgName;
        setLastEdit();
        return this;
    }

    //Constructor(s)
    public Organization() {
        super();
    }

    //Methods
    public String toString() {
        return "Organization name: " + getOrgName()
                + "\nAddress: " + getAddress()
                + "\nNumber: " + getPhoneNumber()
                + "\nTime created: " + getCreated()
                + "\nTime last edit: " + getLastEdit();
    }

    @Override
    public String getFullName() {
        return orgName;
    }

    @Override
    public String contactFields() {
        return "name, address, number";
    }

    @Override
    public void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a field (" + contactFields() + "): ");
        String editField = scanner.nextLine();
        System.out.print("Enter " + editField + ": ");
        String newValue = scanner.nextLine();
        editField(editField, newValue);
    }

    @Override
    void editField(String field, String newValue) {
        switch (field) {
            case "name":
                setOrgName(newValue);
                break;
            case "address":
                setAddress(newValue);
                break;
            case "number":
                setPhoneNumber(newValue);
                break;
            default:
                System.out.println("Invalid field!");
        }
    }

    @Override
    String getFieldValue(String field) {
        switch (field) {
            case "name":
                return getOrgName();
            case "address":
                return getAddress();
            case "number":
                return getPhoneNumber();
            default:
                return "Invalid field";
        }
    }

    @Override
    String allFieldsConcat() {
        return getOrgName() + getAddress() + getPhoneNumber();
    }
}
