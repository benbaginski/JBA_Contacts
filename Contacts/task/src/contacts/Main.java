package contacts;


import java.util.Scanner;

public class Main {
    public static class UserInterface {
        //Runs the Dialog Prompt that the user interacts with.

        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook;
        String input = "";

        public void dialogPrompt() {
            do {
                System.out.print("Enter action (add, remove, edit, count, list, exit): ");
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
                    case "list":
                        phoneBook.list();
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

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        UserInterface userInterface = new UserInterface(phoneBook);
        userInterface.dialogPrompt();
    }
}
