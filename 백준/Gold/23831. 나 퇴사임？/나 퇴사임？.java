import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br; 
	
	static final int HAPPINESS_SIZE = 4, MIN_VALUE = Integer.MIN_VALUE;
	static int N, A, B, max;
	static int[][] happiness;
	static int[][][][] memorization;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	private static void init() throws IOException {
		max = 0;
		
		N = Integer.parseInt(br.readLine());
		happiness = new int[N][HAPPINESS_SIZE];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < HAPPINESS_SIZE; j++) happiness[i][j] = Integer.parseInt(st.nextToken());
		}
		
		memorization = new int[N + 1][N + 1][N + 1][HAPPINESS_SIZE];
		
		for (int [][][] memorize : memorization) {
			for (int[][] memo : memorize) {
				for (int[] m : memo) Arrays.fill(m, MIN_VALUE);
			}
		}
		
		System.out.println(dp(0, 0, 0, 0));
	}
	
	static int dp(int depth, int a, int b, int pre) {
		if (depth == N) return b < B ? MIN_VALUE : 0;
		
		int current = memorization[depth][a][b][pre];
		if (current != MIN_VALUE) return current;		
		
		if (A > a) current = Math.max(current, dp(depth + 1, a + 1, b, 3) + happiness[depth][3]);
		if (pre != 2) current = Math.max(current, dp(depth + 1, a, b, 2) + happiness[depth][2]);
		
		current = Math.max(current, dp(depth + 1, a, b + 1, 1) + happiness[depth][1]);
		current = Math.max(current, dp(depth + 1, a, b + 1, 0) + happiness[depth][0]);
		
		return memorization[depth][a][b][pre] = current;
	}
}