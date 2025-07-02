import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static final BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] spaces = new int[n];

        st = getStringTokenizer();
        for (int i = 0; i < n; i++) {
            spaces[i] = Integer.parseInt(st.nextToken()); // 공간에 사람 저장
        }

        st = getStringTokenizer();
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long answer = 0;
        for (int i = 0; i < n; i++) {
            int current = spaces[i] - b; // 총감독관의 할당량(b)을 감소시키고, 나눴을 때 수를 구하기 위해서 + c - 1
            answer++; // 총감독관 수 증가

            if (current > 0) { // 부감독관이 필요하다면 ?
                answer += (current + c - 1) / c;
            }
        }
        System.out.println(answer);

        br.close();
    }

    public static StringTokenizer getStringTokenizer() throws IOException {
        return new StringTokenizer(br.readLine());
    }
}