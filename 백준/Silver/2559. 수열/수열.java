import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> numbers = new ArrayList<>();
        new StringTokenizer(br.readLine()).asIterator().forEachRemaining(val -> numbers.add(Integer.parseInt((String) val)));

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n - k + 1; i++) {
            int result = 0;
            for (int j = i; j < i + k; j++) {
                result += numbers.get(j);
            }
            answer = Math.max(answer, result);
        }

        System.out.println(answer);
    }
}