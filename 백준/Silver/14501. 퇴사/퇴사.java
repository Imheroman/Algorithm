import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br;
	static int N;
	static int[] t, p, dp;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
	}
	
	public static void init() throws IOException{
		N = Integer.parseInt(br.readLine());
		
		t = new int[N + 1];
		p = new int[N + 1];
		dp = new int[N + 1];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	public static void solve() {
		for (int i = 0; i < N; i++) {
			int target = i + t[i];
			
			if (target <= N) // 업데이트는 이 전 까지만 하고, N까지의 DP 값을 초기화해줘야 하기 때문에, continue는 불가능
				// 방문하려는 곳의 현재까지 최댓값이 지금까지 더한 최댓값에 현재 값을 더해서 방문하는 노드에 값보다 큰지 비
				dp[target] = dp[target] > p[i] + dp[i] ? dp[target] : p[i] + dp[i];   
			
			
			// dp의 값이 계속해서 update 되도록 max값 유지 (선택하지 않았더라도 이전의 값이 들어올 수 있도록)
			dp[i + 1] = dp[i] > dp[i + 1] ? dp[i] : dp[i + 1];
		}
		
		System.out.println(dp[N]);
	}
}