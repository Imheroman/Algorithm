import java.io.*;
import java.util.Arrays;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int X = 0, Y = 1;
	static int N, guess;
	static int[] pos;
	static int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int[][] graphs;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		init();
		solve();
		for (int[] graph : graphs) {
			for (int number : graph) {
				sb.append(number).append(" ");
			}
			sb.append("\n");
		}
		
		sb.append(pos[0]).append(" ").append(pos[1]);
		System.out.println(sb);
	}

	public static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		guess = Integer.parseInt(br.readLine());
		graphs = new int[N][N];
		pos = new int[]{N / 2 + 1, N / 2 + 1};
	}

	public static void solve() {
		int x = N / 2, y = N / 2, number = 1;
		graphs[x][y] = number++;
		
		for (int range = N / 2; range > 0; range--) {
			for (int[] d : DIRECTIONS) {
				while ((range - 1 <= x + d[X] && x + d[X] <= N - range) && (range - 1 <= y + d[Y] && y + d[Y] <= N - range)) {
					x += d[X];
					y += d[Y];
					
					if (number == guess) {
						pos[0] = x + 1;
						pos[1] = y + 1;
					}
					
					graphs[x][y] = number++;
				}
			}
		}
	}
}