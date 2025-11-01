import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, ans;
	static int[][] graphs, DIRECTIONS = {{0, 1}, {1, 0}, {1, 1}};
	static Map<Integer, int[]> DIRECTIONS_MAP = new HashMap<>();
	
	static {
		DIRECTIONS_MAP.put(0, new int[] {0, 2});
		DIRECTIONS_MAP.put(1, new int[] {1, 2});
		DIRECTIONS_MAP.put(2, new int[] {0, 1, 2});
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	static void init() throws IOException {
		ans = 0;
		
		N = Integer.parseInt(br.readLine());
		
		graphs = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N;j ++) graphs[i][j] = Integer.parseInt(st.nextToken());
		}
		
		solve();
	}
  
	static void solve() {
		bt(0, 1, 0);
		System.out.println(ans);
	}

	private static void bt(int x, int y, int preDirection) {
		if (x == N - 1 && y == N - 1) {
			++ans;
			return;
		}
      
		for (int d : DIRECTIONS_MAP.get(preDirection)) {
			int nx = x + DIRECTIONS[d][0], ny = y + DIRECTIONS[d][1];

			boolean flag = true;
			if (d == 2) {
				for (int[] ds : DIRECTIONS)  {
					int nr = x + ds[0], nc = y + ds[1];
					flag = flag && (isValidRange(nr, nc) && graphs[nr][nc] == 0);
				}
			}
			else if (!isValidRange(nx, ny) || graphs[nx][ny] == 1) continue;
			
			if (flag) bt(nx, ny, d);
		}
	}
	
	static boolean isValidRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N; 
	}
}