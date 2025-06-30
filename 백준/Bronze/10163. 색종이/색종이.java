import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX_SIZE = 1002;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] visited = new int[MAX_SIZE][MAX_SIZE];

        for (int i = 0; i < n; i++) {
             st = new StringTokenizer(br.readLine());
             int x = Integer.parseInt(st.nextToken());
             int y = Integer.parseInt(st.nextToken());
             int w = Integer.parseInt(st.nextToken());
             int h = Integer.parseInt(st.nextToken());

            for (int j = 0; j < w; j++) {
                for (int k = 0; k < h; k++) {
                    visited[x + j][y + k] = i + 1;
                }
            }
        }

        int[] answer = new int[n];
        for (int j = 0; j < MAX_SIZE; j++) {
            for (int k = 0; k < MAX_SIZE; k++) {
                if (visited[j][k] != 0) {
                    answer[visited[j][k] - 1]++;
                }
            }
        }

        Arrays.stream(answer).forEach(System.out::println);
    }
}