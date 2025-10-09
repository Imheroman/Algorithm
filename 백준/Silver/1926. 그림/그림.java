import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb;
	static int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()),
				M = Integer.parseInt(st.nextToken());
		
		int[][] graphs = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) graphs[i][j] = Integer.parseInt(st.nextToken());
		}
		
		solve(graphs, N, M);
	}
	
	static void solve(int[][] graphs, int N, int M) {
		int max = 0, cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graphs[i][j] == 1) {
					int res = bfs(graphs, new int[] {i, j}, N, M);
					max = max > res ? max : res;
					++cnt;
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(max);
	}

	static int bfs(int[][] graphs, int[] pos, int N, int M) {
		int res = 1;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(pos);
		graphs[pos[0]][pos[1]] = 0;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for (int[] d : DIRECTIONS) {
				int nx = cur[0] + d[0], ny = cur[1] + d[1];
				
				if (!(0 <= nx && nx < N && 0 <= ny && ny < M && graphs[nx][ny] == 1)) continue;
				
				queue.offer(new int[] {nx, ny});
				graphs[nx][ny] = 0;
				++res;
			}
		}
		
		return res;
	}
}