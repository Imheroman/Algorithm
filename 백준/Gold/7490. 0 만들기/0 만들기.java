import java.io.*;
import java.util.*;

//잼민이 코드 통과되는지 궁금
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            dfs(1, "1");
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int depth, String exp) {
        if (depth == N) {
            if (calculate(exp) == 0) {
                sb.append(exp).append("\n");
            }
            return;
        }

        int next = depth + 1;
        dfs(next, exp.concat(" ").concat(String.valueOf(next)));
        dfs(next, exp.concat("+").concat(String.valueOf(next)));
        dfs(next, exp.concat("-").concat(String.valueOf(next)));
    }

    static int calculate(String str) {
        str = str.replaceAll(" ", "");
        
        StringTokenizer st = new StringTokenizer(str, "+-", true);
        int sum = Integer.parseInt(st.nextToken()); // 첫 번째 숫자
        
        while (st.hasMoreTokens()) {
            String op = st.nextToken(); // 연산자 (+ 또는 -)
            int num = Integer.parseInt(st.nextToken()); // 다음 숫자
            
            if (op.equals("+")) sum += num;
            else sum -= num;
        }
        return sum;
    }
}