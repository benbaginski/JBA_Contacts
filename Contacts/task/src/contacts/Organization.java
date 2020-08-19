package contacts;

import java.util.Scanner;

public class Organization extends Contact {

    private String address = "[no data]";
    private String orgName = "[no data]";

    //Getters & Setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        setLastEdit();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
        setLastEdit();
    }

    //Constructors
    public Organization(String orgName, String address, String number) {
        super(number);
        this.address = address;
        this.orgName = orgName;
    }

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
    public String returnName() {
        return orgName;
    }

    @Override
    public void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a field (Organization, address, number): ");
        String editField = scanner.nextLine();

        switch (editField) {
            case "organization":
                setOrgName(scanner.nextLine());
                break;
            case "address":
                setAddress(scanner.nextLine());
                break;
            case "number":
                setPhoneNumber(scanner.nextLine());
                break;
            default:
                System.out.println("Invalid field!");
        }
    }
}
