import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static final int[] DIRECTIONS_X = new int[] {-1, 0, 1, 0};
    public static final int[] DIRECTIONS_Y = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(br.readLine());

        solve(r, c, order);
    }

    public static void solve(int r, int c, int order) {
        order--;
        if (order > c * r) {
            System.out.println(0);
            return;
        }

        boolean[][] visited = new boolean[r][c];
        int x = r - 1;
        int y = 0;
        int direction = 0;

        while (order > 0) {
            visited[x][y] = true;

            if (!(0 <= x + DIRECTIONS_X[direction] && x + DIRECTIONS_X[direction] < r &&
                    0 <= y + DIRECTIONS_Y[direction] && y + DIRECTIONS_Y[direction] < c) ||
                    visited[x + DIRECTIONS_X[direction]][y + DIRECTIONS_Y[direction]]) {
                direction = (direction + 1) % 4;
            }

            x += DIRECTIONS_X[direction];
            y += DIRECTIONS_Y[direction];
            order--;
        }

        System.out.println(y + 1 + " " + (r - x));
        return;
    }
}