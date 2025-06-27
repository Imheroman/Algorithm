import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] repository = new int[n];

        repository[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            repository[i] = repository[i - 1] + Integer.parseInt(st.nextToken());
        }

        int answer = repository[k - 1];
        for (int i = k; i < n; i++) {
            answer = Math.max(answer, repository[i] - repository[i - k]);
        }

        System.out.println(answer);
    }
}