import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime ldt1 = LocalDateTime.parse(scanner.nextLine().trim());
        LocalDateTime ldt2 = LocalDateTime.parse(scanner.nextLine().trim());

        System.out.println(ldt1.until(ldt2, ChronoUnit.HOURS));
    }
}