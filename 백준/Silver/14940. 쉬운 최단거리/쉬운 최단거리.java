import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static int[] startPos;
	static int[][] graphs;
	static int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		init();
		solve();
		
		for (int i = 0 ; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if ((i == startPos[0] && j == startPos[1]) || graphs[i][j] == -1) sb.append(0);
				else if (graphs[i][j] == 0) sb.append(-1);
				else sb.append(graphs[i][j]);
				
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graphs = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				
				if (value == 2) {
					startPos = new int[] {i, j};
					graphs[i][j] = 0;
				} 
				else if (value == 1) graphs[i][j] = 0;
				else graphs[i][j] = -1;
			}
		}
		
	}

	public static void solve() {
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(startPos);
		visited[startPos[0]][startPos[1]] = true;
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			
			for (int[] d : DIRECTIONS) {
				int nx = current[0] + d[0], ny = current[1] + d[1];
				
				if ((startPos[0] != nx || startPos[1] != ny) &&
						0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (graphs[nx][ny] != 0 && graphs[nx][ny] <= graphs[current[0]][current[1]] + 1) continue;
					if (graphs[nx][ny] == 0) graphs[nx][ny] = graphs[current[0]][current[1]] + 1;
					else if (graphs[nx][ny] > graphs[current[0]][current[1]] + 1) graphs[nx][ny] = graphs[current[0]][current[1]] + 1;
					
					queue.offer(new int[] {nx, ny});
				}
			}
		}
	}
}