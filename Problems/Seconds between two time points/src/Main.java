import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalTime t1 = LocalTime.parse(scanner.nextLine());
        LocalTime t2 = LocalTime.parse(scanner.nextLine());

        System.out.println(secondsBetween(t1, t2));
        LocalTime.M
    }

    public static int secondsBetween(LocalTime t1, LocalTime t2) {
        return Math.abs(t1.toSecondOfDay() - t2.toSecondOfDay());
    }
}