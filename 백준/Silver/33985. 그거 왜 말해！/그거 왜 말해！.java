import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String letters = br.readLine();

        if (letters.charAt(0) == 'B' || letters.charAt(letters.length() - 1) == 'A') {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}