import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br;
	static int V = 0, C = 1;
	static int N, K, ans;
	static int[][] items, dp;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            init();
            bt(0, 0);
            System.out.println("#" + t + " " + ans);
        }
	}
	

	static void init() throws IOException {
		ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		items = new int[N][2];
		dp = new int[N][K];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			items[i][0] = Integer.parseInt(st.nextToken());
			items[i][1] = Integer.parseInt(st.nextToken());
			Arrays.fill(dp[i], -1);
		}
	}
	
    // github upload code
	static int bt(int idx, int v) {
		if (v > K) return -99999999;
		if (v == K || idx >= N) return 0;
		if (dp[idx][v] != -1) return dp[idx][v];
		
		int a = bt(idx + 1, v);
		int b = bt(idx + 1, v + items[idx][0]) + items[idx][1];
		int max = a > b ? a : b;
      
		if (ans < max) ans = max;
		return dp[idx][v] = max;
	}
}