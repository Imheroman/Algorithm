import java.io.*;
import java.util.*;

public class Main {
	static final int MAX_VALUE = 1_999_999_999, MOD = 1_000_000_007;
	static int N, M;
	static long[][] memo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		memo = new long[N + 1][M + 1];
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) memo[i][j] = MAX_VALUE;
		}
		memo[1][1] = 1;
		
		dp(N, M);
		System.out.println(memo[N][M]);
	}
	
	public static long dp(int x, int y) {
		if (!((0 <= x && x < N + 1) && (0 <= y && y < M + 1))) return MAX_VALUE;
		if (memo[x][y] != MAX_VALUE) return memo[x][y];
		
		return memo[x][y] = (dp(x - 1, y) + dp(x, y - 1) + dp(x - 1, y - 1)) % MOD;
	}
}