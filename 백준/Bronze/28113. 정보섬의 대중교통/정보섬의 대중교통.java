import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int walk = Integer.parseInt(st.nextToken());
        int bus = Integer.parseInt(st.nextToken());
        int subway = Integer.parseInt(st.nextToken());

        int sub = walk + subway - walk;
        if (bus == sub) {
            System.out.println("Anything");
        } else if (bus > sub) {
            System.out.println("Subway");
        } else {
            System.out.println("Bus");
        }
    }
}