import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb;
	static int MAX_DIST = 100_008;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()),
				k = Integer.parseInt(st.nextToken());
		
		if (n >= k) {
			System.out.println(n - k);
			return;
		}
		
		int[] times = new int[MAX_DIST];
		Arrays.fill(times, 999999999);
		times[n] = 0;
		
		solve(times, n, k);
	}
	
	static void solve(int[] times, int N, int K) {
		Queue<Integer> queue = new PriorityQueue<>(); 
		queue.offer(N);
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int move : moveable(cur)) {
				if (move >= MAX_DIST || move < 0 || times[move] <= times[cur] + 1) continue;
				
				queue.offer(move);
				times[move] = times[cur] + 1;
			}
		}
		
		System.out.println(times[K]);
	}
	
	static int[] moveable(int n) {
		return new int[] {n + 1, n - 1, n * 2};
	}
}