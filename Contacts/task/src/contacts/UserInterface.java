package contacts;

import java.util.Scanner;

//Runs the Dialog Prompt that the user interacts with.
public class UserInterface {

    Scanner scanner = new Scanner(System.in);
    PhoneBook phoneBook;
    String input = "";

    public void dialogPrompt() {
        do {
            System.out.print("\nEnter action (add, remove, edit, count, info, exit): ");
            input = scanner.nextLine().replace(" ", "");
            switch (input) {
                case "add":
                    phoneBook.add();
                    break;
                case "remove":
                    phoneBook.remove();
                    break;
                case "edit":
                    phoneBook.edit();
                    break;
                case "count":
                    phoneBook.count();
                    break;
                case "info":
                    phoneBook.info();
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Invalid Command!");
            }

        } while (input.compareTo("exit") != 0);
    }

    public UserInterface(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

}