package contacts;

public class Main {

    public static void main(String[] args) {
        String phoneBookFile;
        PhoneBook phoneBook;
        try {
            phoneBookFile = args[0];
            phoneBook = new PhoneBook(phoneBookFile);
        } catch (IndexOutOfBoundsException e) {
            phoneBook = new PhoneBook();
        }

        new UserInterface(phoneBook);
    }
}
