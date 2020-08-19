package contacts;

public class OrganizationFactory extends ContactFactory {

    @Override
    public Contact createContact() {
        Organization organization = new Organization();
        System.out.print("Enter the organization name: ");
        organization.setOrgName(scanner.nextLine());
        System.out.print("Enter the address: ");
        organization.setAddress(scanner.nextLine());
        System.out.print("Enter the number: ");
        organization.setPhoneNumber(scanner.nextLine());
        System.out.print("The record added.\n");
        return organization;
    }
}
