import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br; 
	
	static int N, K;
	static Queue<Integer> queue;
	static int[] hamburgers;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	private static void init() throws IOException {
		queue = new ArrayDeque<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		String h = br.readLine();
		hamburgers = new int[N];
		for (int i = 0; i < N; i++) {
			char current = h.charAt(i);
			
			if (current == 'H') hamburgers[i] = 1;
			else queue.offer(i);
		}
		
		solve();
	}
	
	static void solve() {
		int cnt = 0;
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int idx = cur - K; idx <= cur + K; idx++) {
				if (!(0 <= idx && idx < N && hamburgers[idx] > 0)) continue;
				
				++cnt;
				--hamburgers[idx];
				break;
			}
		}
		
		System.out.println(cnt);
	}
}