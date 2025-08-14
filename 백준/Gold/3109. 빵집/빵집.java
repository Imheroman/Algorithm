import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean result;
	static int R, C, answer = 0;
	static int[][] graphs;
	static int[][] DIRECTIONS = { { -1, 1 }, { 0, 1 }, { 1, 1 } };

	public static void main(String[] args) throws IOException {
		init();
		solve();
		System.out.println(answer);
	}

	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		graphs = new int[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				graphs[i][j] = (line.charAt(j) == '.') ? 0 : -1;
			}
		}
	}

	static void solve() {
		final int START_COL = 0;
		for (int r = 0; r < R; r++) {
			if (graphs[r][START_COL] == 0) {
				++answer;
				result = false;
				graphs[r][START_COL] = answer;
				if (!dfs(r, START_COL)) {
					--answer;
				}
			}
		}
	}

	static boolean dfs(int r, int c) {
		if (c == C - 1) {
			result = true;
			return result;
		}

		for (int[] d : DIRECTIONS) {
			int nx = r + d[0], ny = c + d[1];

			if (0 <= nx && nx < R && 0 <= ny && ny < C && graphs[nx][ny] == 0 && !result) {
				graphs[nx][ny] = answer;
				dfs(nx, ny);
			}
		}

		return result;
	}
}