import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static int W = 0, V = 1;
	static int N, K, ans;
	static int[][] items, dp;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		System.out.println(ans);			
	}

	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		items = new int[N][2];
		dp = new int[N + 1][K + 1];
		
		for (int i = 0; i <  N; i++) {
			st = new StringTokenizer(br.readLine());
			
			items[i][W] = Integer.parseInt(st.nextToken());
			items[i][V] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solve() {
		for (int i = 1; i < N + 1; i++) { // item index
			int weight = items[i - 1][W];  // 현재 아이템 weight
			int value = items[i - 1][V];  // 현재 아이템 value
			
			for (int w = 0; w < K + 1; w++) {  // weight index
				if (weight > w) dp[i][w] = dp[i - 1][w];  // 현재 아이템이 w보다 크면 continue -> 접근할 수 없음
				else dp[i][w] = Math.max(dp[i - 1][w],  // 이전에서 바로 오는 값
							dp[i - 1][w - weight] + value);  // 이전 값에서 아이템을 선택한 값
			}
		}
		
		for (int val : dp[N]) ans = ans > val ? ans : val;  // 최댓값 고르기
	}
}