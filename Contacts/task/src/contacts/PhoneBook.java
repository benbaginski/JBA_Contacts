package contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<Contact> contactList = new ArrayList<>();
    private String fileName;

    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    public PhoneBook() {

    }

    public PhoneBook(String fileName) {
        this.fileName = fileName;
        contactList = openContactList();
    }

    public void add() {
        Scanner scanner = new Scanner(System.in);
        PersonFactory personFactory = new PersonFactory();
        OrganizationFactory organizationFactory = new OrganizationFactory();

        System.out.print("Enter the type (person, organization): ");
        switch (scanner.nextLine().strip()) {
            case "person":
                contactList.add(personFactory.createContact());
                saveContactList(contactList);
                System.out.println("Saved record.");
                break;
            case "organization":
                contactList.add(organizationFactory.createContact());
                saveContactList(contactList);
                System.out.println("Saved record.");
                break;
            default:
                System.out.println("Invalid contact type");
                break;
        }
    }

    public void delete(Contact contact) {
        contactList.remove(contact);
        saveContactList(contactList);
    }

    public void edit(Contact contact) {
        contact.edit();
        saveContactList(contactList);
        System.out.println("Saved");
        System.out.println(contact);
    }

    public void count() {
        System.out.println("The Phone Book has " + contactList.size() + " records.");
    }

    public void list() {
        if (contactList.size() <= 0) {
            System.out.println("No records to list!");
        } else {
            for (int i = 0; i < contactList.size(); i++) {
                System.out.println(i + 1 + ". " + contactList.get(i).getFullName());
            }
        }
    }

    public void list(ArrayList<Contact> contactList) {
        if (contactList.size() <= 0) {
            System.out.println("No records to list!");
        } else {
            for (int i = 0; i < contactList.size(); i++) {
                System.out.println(i + 1 + ". " + contactList.get(i).getFullName());
            }
        }
    }

    public ArrayList<Contact> search() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Contact> searchResults = new ArrayList<>();

        System.out.print("Enter search query: ");
        Pattern pattern = Pattern.compile(".*" + scanner.nextLine() + ".*", Pattern.CASE_INSENSITIVE);
        for (Contact c : contactList) {
            Matcher nameMatcher = pattern.matcher(c.allFieldsConcat());
            if (nameMatcher.find()) {
                searchResults.add(c);
            }
        }
        System.out.println("Found " + searchResults.size() + " results: ");
        list(searchResults);
        return searchResults;
    }

    public void saveContactList(ArrayList<Contact> contactList) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(contactList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {

        }
    }

    public ArrayList<Contact> openContactList() {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (ArrayList<Contact>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Contacts file not found!");
            return new ArrayList<Contact>();
        } catch (IOException e) {
            System.out.println("I/O Exception!");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found exception!");
        }
        return null;
    }
}

