import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static final BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
    public static StringTokenizer st;
    public static final int GENDER_SIZE = 2;
    public static final int GRADE_SIZE = 6;

    public static void main(String[] args) throws IOException {
        st = getStringTokenizer();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] students = new int[GENDER_SIZE][GRADE_SIZE];
        for (int i = 0; i < n; i++) {
            st = getStringTokenizer();
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            students[gender][grade - 1]++;
        }

        int answer = 0;
        for (int i = 0; i < GENDER_SIZE; i++) {
            for (int j = 0; j < GRADE_SIZE; j++) {
                answer += (students[i][j] + k - 1) / k;
            }
        }

        System.out.println(answer);
    }

    public static StringTokenizer getStringTokenizer() throws IOException {
        return new StringTokenizer(br.readLine());
    }
}