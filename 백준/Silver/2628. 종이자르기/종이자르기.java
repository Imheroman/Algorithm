import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        List<Integer> row = new ArrayList<>(List.of(0, r));
        List<Integer> col = new ArrayList<>(List.of(0, c));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            if (type.equals("0")) {
                row.add(Integer.parseInt(st.nextToken()));
            } else {
                col.add(Integer.parseInt(st.nextToken()));
            }
        }

        row.sort(Integer::compareTo);
        col.sort(Integer::compareTo);

        int answer = -1;
        for (int i = 0; i < row.size() - 1; i++) {
            for (int j = 0; j < col.size() - 1; j++) {
                answer = Math.max(answer, (row.get(i + 1) - row.get(i)) * (col.get(j + 1) - col.get(j)));
            }
        }

        System.out.println(answer);
        br.close();
    }
}