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
			String line = br.readLine();
			for (int j = 0; j < M; j++)
				graphs[i][j] = line.charAt(j) - '0';
		}
		
		solve(graphs, N, M);
	}
	
	static void solve(int[][] graphs, int N, int M) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {0, 0});
		
		int[][] visited = new int[N][M];
		visited[0][0] = 1;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for (int[] d : DIRECTIONS) {
				int nx = cur[0] + d[0], ny = cur[1] + d[1];
				
				if (!(0 <= nx && nx < N && 0 <= ny && ny < M && graphs[nx][ny] == 1 && visited[nx][ny] == 0)) continue;
				
				visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
				queue.offer(new int[] {nx, ny});
			}
		}

		System.out.println(visited[N - 1][M - 1]);
	}
}