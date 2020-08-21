import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountEvenNumbers {
    public static void main(String[] args) {
        File file = new File("Problems/Count even numbers/Numbers.txt");
        int evenCount = 0;

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextInt()) {
                int nextInt = scanner.nextInt();
                if (nextInt == 0) break;
                if (nextInt % 2 == 0) evenCount++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        System.out.println("Even Count: " + evenCount);
    }
}

