package contacts;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    ArrayList<Contact> contactList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    PersonFactory personFactory = new PersonFactory();
    OrganizationFactory organizationFactory = new OrganizationFactory();

    public void add() {
        System.out.print("Enter the type (person, organization): ");
        switch (scanner.nextLine().strip()) {
            case "person":
                contactList.add(personFactory.createContact());
                break;
            case "organization":
                contactList.add(organizationFactory.createContact());
                break;
            default:
                System.out.println("Invalid contact type");
                break;
        }
    }

    public void remove() {
        if (contactList.size() <= 0) {
            System.out.println("No records to remove!");
            return;
        }

        list();
        System.out.print("Select a record: ");

        int index = scanner.nextInt();
        if (index <= contactList.size()) {
            contactList.remove(index - 1);
            System.out.println("The record removed!");
        } else System.out.println("Invalid Record Index!");
    }

    public void edit() {
        if (contactList.size() <= 0) {
            System.out.println("No records to edit!");
            return;
        }
        list();
        System.out.print("Select a record: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        contactList.get(index - 1).edit();
        System.out.println("The record updated!");
    }

    public void count() {
        System.out.println("The Phone Book has " + contactList.size() + " records.");
    }

    public void list() {
        if (contactList.size() <= 0) {
            System.out.println("No records to list!");
        } else {
            for (int i = 0; i < contactList.size(); i++) {
                System.out.println(i + 1 + ". " + contactList.get(i).returnName());
            }
        }
    }

    public void info() {
        if (contactList.size() <= 0) {
            System.out.print("No records to edit!");
            return;
        }
        list();
        System.out.print("Select index to show info: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        System.out.println(contactList.get(index).toString());
    }
}

