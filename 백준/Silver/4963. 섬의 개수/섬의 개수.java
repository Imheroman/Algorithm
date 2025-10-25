import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	static void init() throws IOException {
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			if (W == 0 && H == 0) break;
			
			int[][] graphs = new int[W][H];
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < H; j++) graphs[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int res = solve(graphs, W, H);
			sb.append(res).append("\n");
		}
		
		System.out.println(sb);
	}

	static int solve(int[][] graphs, int W, int H) {
		int cnt = 0;
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				if (graphs[i][j] == 0) continue;
				
				++cnt;
				bfs(graphs, W, H, new int[] {i, j});
			}
		}
		
		return cnt;
	}

	private static void bfs(int[][] graphs, int W, int H, int[] pos) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(pos);
		graphs[pos[0]][pos[1]] = 0;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for (int[] d : DIRECTIONS) {
				int nx = cur[0] + d[0], ny = cur[1] + d[1];
				
				if (!(0 <= nx && nx < W && 0 <= ny && ny < H && graphs[nx][ny] == 1)) continue;
				
				graphs[nx][ny] =0;
				queue.offer(new int[] {nx, ny});
			}
		}
	}
	
}