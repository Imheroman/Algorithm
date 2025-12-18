import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br; 

	static final int MAX_VALUE = 1_999_999_999;
	static int N, M;
	static int[][] items, memorization;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}
	
	private static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		memorization = new int[N][M];
		items = new int[N][M];
        
		for (int i = 0; i < N; i++) {
			Arrays.fill(memorization[i], MAX_VALUE);
            
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) items[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for (int col = 0; col < M; col++) dp(col, 0);
        
		int min = memorization[0][0];
		for (int i = 1; i < M; i++) min = Math.min(min, memorization[0][i]);
		System.out.println(min);
	}
	
	static int dp(int pre, int depth) {
		if (depth == N) return 0;
		if (memorization[depth][pre] != MAX_VALUE) return memorization[depth][pre]; 
	
		int min = MAX_VALUE;
		for (int col = 0; col < M; col++) {
			if (col == pre) continue;
			int result = dp(col, depth + 1) + items[depth][pre];  // 이전 꺼에서 나를 선택한 값 ?
			min = Math.min(min, result);
		}
		
		return memorization[depth][pre] = Math.min(memorization[depth][pre], min);
	}
}