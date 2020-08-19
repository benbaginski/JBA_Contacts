package contacts;

import java.util.Scanner;

abstract class ContactFactory {

    Scanner scanner = new Scanner(System.in);

    abstract Contact createContact();
}
