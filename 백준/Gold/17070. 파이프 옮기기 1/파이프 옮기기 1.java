import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static final int MAX_VALUE = 1_999_999_999;
	static int N;
	static int[][] graphs, DIRECTIONS = {{0, 1}, {1, 0}, {1, 1}};
	static Map<Integer, int[]> DIRECTIONS_MAP = new HashMap<>();
	static int[][][] memoization;
	
	
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
		N = Integer.parseInt(br.readLine());
		graphs = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N;j ++) graphs[i][j] = Integer.parseInt(st.nextToken());
		}
		
		memoization = new int[DIRECTIONS.length][N][N];
		for (int d = 0; d < DIRECTIONS.length; d++) {
			for (int x = 0; x < N; x++) Arrays.fill(memoization[d][x], MAX_VALUE);
		}
		
		System.out.println(bt(0, 1, 0));
	}
	
	private static int bt(int x, int y, int preDirection) {
		if (x == N - 1 && y == N - 1) return 1; 
		if (memoization[preDirection][x][y] != MAX_VALUE) return memoization[preDirection][x][y];
		
		memoization[preDirection][x][y] = 0;
		
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
			
			if (flag) memoization[preDirection][x][y] += bt(nx, ny, d);
		}
		
		return memoization[preDirection][x][y];
	}
	
	static boolean isValidRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N; 
	}
}