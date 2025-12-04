import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br; 
	static int N;
	static int[] stones;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	private static void init() throws IOException {		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		stones = new int[N];
		for (int i = 0; i < N; i++) stones[i] = Integer.parseInt(st.nextToken());
		
		solve(Integer.parseInt(br.readLine()) - 1);
	}
	
	static void solve(int start) {
		int cnt = 0;
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {start, stones[start]});
		stones[start] = -1;
		
		while (!queue.isEmpty()) {
			++cnt;
			int[] cur = queue.poll();
			
			for (int next : new int[] {cur[0] + cur[1], cur[0] - cur[1]}) {
				if (!(0 <= next && next < N && stones[next] != -1)) continue;
				
				queue.offer(new int[] {next, stones[next]});
				stones[next] = -1;
			}
		}
		
		System.out.println(cnt);
	}
}