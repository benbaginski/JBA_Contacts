package contacts;

public class PersonFactory extends ContactFactory {

    @Override
    public Contact createContact() {
        Person person = new Person();
        System.out.print("Enter the name: ");
        person.setFirstName(scanner.nextLine());
        System.out.print("Enter the surname: ");
        person.setLastName(scanner.nextLine());
        System.out.print("Enter the birth date: ");
        person.setBirthdate(scanner.nextLine());
        System.out.print("Enter the gender (M,F): ");
        person.setGender(scanner.nextLine());
        System.out.print("Enter the number: ");
        person.setPhoneNumber(scanner.nextLine());
        System.out.print("The record added.\n");
        return person;
    }
}
