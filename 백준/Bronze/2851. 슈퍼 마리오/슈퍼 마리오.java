import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static final BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = 10;

        int pre = 0;
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            int current = pre + number;

            if (current > 100) {
                pre = Math.abs(100 - current) > Math.abs(100 - pre) ? pre : current;
                break;
            }
            
            pre = current;
        }

        System.out.println(pre);
        br.close();
    }
}