import java.io.InputStream;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;

        do {
            System.out.print(inputStream.read());
        } while (inputStream.available() != 0);
    }
}