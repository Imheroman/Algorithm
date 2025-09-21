import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static int NODE = 0, COST = 1;
	static int N, K, ans;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
		System.out.println(ans);
	}
	
	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if (N >= K) {  // N >= K 인 경우는 -1씩 밖에 못 함
			ans = N - K;
			return;
		}
      
		solve();
	}
	
	static void solve() {
        // dijkstra
		Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[COST]));
		queue.offer(new int[] {N, 0});
		
		int[] costs = new int[K + 10];
		for (int cur = 0; cur < K + 10; cur++) costs[cur] = Math.abs(N - cur);
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			if (cur[1] > costs[cur[0]]) continue;
			
			for (int[] d : calDir(cur)) {
				if (!(0 < d[NODE] && d[NODE] < K + 10)) continue;
				
				if (costs[d[NODE]] >= d[COST]) {
					costs[d[NODE]] = d[COST];
					queue.offer(new int[] {d[NODE], d[COST]});
				}
			}
		}
		
		ans = costs[K];
	} 
	
	static int[][] calDir(int[] cur) {
        // 현재 노드에서 갈 수 있는 거리 계산
		int index = cur[0], cnt = cur[1];
		return new int[][] {
			{index + 1, cnt + 1},
			{index - 1, cnt + 1},
			{index * 2, cnt}
		};
	}
}
