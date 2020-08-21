package contacts;

import java.util.ArrayList;
import java.util.Scanner;

//Runs the Dialog Prompt that the user interacts with.
public class UserInterface {

    Scanner scanner = new Scanner(System.in);
    PhoneBook phoneBook;
    String input;

    public void menuDialog() {
        do {
            System.out.print("\n[menu] Enter action (add, list, search, count, exit): ");
            input = scanner.nextLine().trim();
            switch (input) {
                case "add":
                    phoneBook.add();
                    break;
                case "list":
                    phoneBook.list();
                    listDialog();
                    break;
                case "search":
                    searchDialog(phoneBook.search());
                    break;
                case "count":
                    phoneBook.count();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Invalid Command!");
            }

        } while (input.compareTo("exit") != 0);
    }

    public void searchDialog(ArrayList<Contact> searchResults) {
        do {
            System.out.print("\n[search] Enter action ([number], back, again): ");
            input = scanner.nextLine().trim();
            switch (input) {
                case "back":
                    return;
                case "again":
                    phoneBook.search();
                    break;
                default:
                    if (input.matches("[0-9]+")) {
                        try {
                            System.out.println(searchResults.get(Integer.parseInt(input) - 1));
                            recordDialog(searchResults.get(Integer.parseInt(input) - 1));
                            return;
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Index out of bounds!");
                        }
                    } else System.out.println("Invalid Command!");
            }
        } while (input.compareTo("back") != 0);
    }

    public void recordDialog(Contact contact) {
        do {
            System.out.print("\n[record] Enter action (edit, delete, menu): ");
            input = scanner.nextLine().trim();
            switch (input) {
                case "edit":
                    phoneBook.edit(contact);
                    break;
                case "delete":
                    phoneBook.delete(contact);
                    break;
                case "menu":
                    return;
                default:
                    System.out.println("Invalid Command!");
            }

        } while (input.compareTo("menu") != 0);
    }

    public void listDialog() {
        do {
            System.out.print("\n[list] Enter action ([number], back): ");
            input = scanner.nextLine().trim();
            switch (input) {
                case "back":
                    return;
                default:
                    if (input.matches("[0-9]+")) {
                        try {
                            System.out.println(phoneBook.getContactList().get(Integer.parseInt(input) - 1));
                            recordDialog(phoneBook.getContactList().get(Integer.parseInt(input) - 1));
                            return;
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Index out of bounds!");
                        }
                    } else System.out.println("Invalid Command!");
            }
        } while (input.compareTo("exit") != 0);
    }

    //Constructor
    public UserInterface(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
        menuDialog();
    }

}