import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	
	static final int MAX_VALUE = 1_999_999_999;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken()),
				C = Integer.parseInt(st.nextToken());
		
		int[][] graphs = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int number = Integer.parseInt(st.nextToken());
				graphs[i][j] = number == 1 ? MAX_VALUE : 0;
			}
		}
		
		int D = Integer.parseInt(br.readLine());
		int[][] directions = new int[D][2];
		for (int d = 0; d < D; d++) {
			st = new StringTokenizer(br.readLine());
			directions[d][0] = Integer.parseInt(st.nextToken());
			directions[d][1] = Integer.parseInt(st.nextToken());
		}
		
		solve(graphs, directions, R, C);
	}

	private static void solve(int[][] graphs, int[][] directions, int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		
		for (int i = 0; i < c; i++) {
			if (graphs[0][i] == MAX_VALUE) {
				queue.offer(new int[] {0, i, 0});
			}
		}
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for (int[] d : directions) {
				int nx = cur[0] + d[0], ny = cur[1] + d[1];
				
				if (!(0 <= nx && nx < r && 0 <= ny && ny < c) || graphs[nx][ny] == 0) continue;
				
				int cost = cur[2] + 1;
				if (graphs[nx][ny] > cost) {
					queue.offer(new int[] {nx, ny, cost});
					graphs[nx][ny] = cost;
				}
			}
		}
		
		int min = MAX_VALUE;
		for (int i = 0; i < c; i++) {
			int current = graphs[r - 1][i];
			if (current != 0) min = min < current ? min : current;
		}
		
		System.out.println(min == MAX_VALUE ? -1 : min);
	}
}