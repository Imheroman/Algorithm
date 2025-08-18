import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int N, M, answer = 0;
	static boolean[][] graphs;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		System.out.println(answer);
	}

	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graphs = new boolean[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			graphs[a][b] = true;
		}
	}

	static void solve() {
		for (int k = 1; k < N + 1; k++) {
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					if (graphs[i][k] && graphs[k][j]) graphs[i][j] = true;
				}
			}
		}

		for (int i = 1; i < N + 1; i++) {
			int count = 0;
			for (int j = 1; j < N + 1; j++) {
				if (graphs[i][j] || graphs[j][i])
					++count;
			}

			if (count == N - 1)
				++answer;
		}
	}
}