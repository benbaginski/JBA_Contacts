import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] s = reader.readLine().trim().split("\\s+");
        if (s[0].isEmpty()) System.out.println("0");
        else System.out.println(s.length);

        reader.close();
    }
}