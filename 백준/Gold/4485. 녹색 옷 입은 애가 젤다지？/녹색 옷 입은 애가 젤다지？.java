import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, answer = 0;
	static int[][] graphs;
	static int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }};

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		int t = 0;
		while ((N = Integer.parseInt(br.readLine())) > 0) {
			init();
			dajikstra();
			sb.append(String.format("Problem %d: %d", ++t, answer)).append("\n");
		}
		System.out.println(sb);
	}

	static void init() throws IOException { // 입력 받는 메소드입니다.
		answer = Integer.MAX_VALUE;
		graphs = new int[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graphs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	public static void dajikstra() {
		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v[0]));
		boolean[][] visited = new boolean[N][N];
		visited[0][0] = true;
		queue.offer(new int[] {graphs[0][0], 0, 0});
		
		int[][] distances = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				distances[i][j] = Integer.MAX_VALUE;				
			}
		}
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int cost = current[0], x = current[1], y = current[2];
			
			if (distances[x][y] < cost) {
				continue;
			}
			
			for (int[] d : DIRECTIONS) {
				int nx = x + d[0], ny = y + d[1];
				
				if (!(0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny])) {
					continue;
				}
				
				int nowCost = cost + graphs[nx][ny];
				
				if (distances[nx][ny] < nowCost) {
					continue;
				}
				
				distances[nx][ny] = nowCost;
				visited[nx][ny] = true;
				queue.offer(new int[] {nowCost, nx, ny});
			}
		}
		
		answer = distances[N - 1][N - 1];
	}
}