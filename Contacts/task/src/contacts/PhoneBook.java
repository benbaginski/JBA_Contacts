package contacts;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    ArrayList<Contact> contactList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void add() {
        System.out.print("Enter the name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter the surname: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter the number: ");
        String phoneNumber = scanner.nextLine();
        contactList.add(new Contact(firstName, lastName, phoneNumber));
        System.out.println("The record added.");
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

        System.out.print("Select a field (name, surname, number): ");
        String editField = scanner.nextLine();

        switch (editField) {
            case "name":
                System.out.print("Enter name: ");
                contactList.get(index - 1).setFirstName(scanner.nextLine());
                break;
            case "surname":
                System.out.print("Enter surname: ");
                contactList.get(index - 1).setLastName(scanner.nextLine());
                break;
            case "number":
                System.out.print("Enter number: ");
                contactList.get(index - 1).setPhoneNumber(scanner.nextLine());
                break;
            default:
                System.out.println("Invalid Field!");
        }
    }

    public void count() {
        System.out.println("The Phone Book has " + contactList.size() + " records.");
    }

    public void list() {
        if (contactList.size() <= 0) {
            System.out.println("No records to list!");
        } else {
            for (int i = 0; i < contactList.size(); i++) {
                System.out.println(i + 1 + ". " + contactList.get(i));
            }
        }
    }
}
