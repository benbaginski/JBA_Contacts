import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateString = scanner.nextLine();
        int offset = scanner.nextInt();

        LocalDate startDate = LocalDate.parse(dateString);
        LocalDate date = startDate;

        while (date.getYear() == startDate.getYear()) {
            System.out.println(date);
            date = date.plusDays(offset);
        }
    }
}