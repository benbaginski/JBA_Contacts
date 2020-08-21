import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(reader.readLine());
        stringBuilder.reverse();
        System.out.println(stringBuilder.toString());

        reader.close();
    }
}