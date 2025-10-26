import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, D, K, C;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
				
		int[] graphs = new int[N];
		for (int i = 0; i < N; i++) graphs[i] = Integer.parseInt(br.readLine());
		
		solve(graphs);
	}
 
	static void solve(int[] graphs) {
		int ans = 0, cnt = 0;
		int[] visited = new int[D + 1];
		
		for (int i = 0; i < K; i++) {
			int cur = graphs[i];
			++visited[cur];
			
			if (visited[cur] == 1) ++cnt;
		}
		
		ans = visited[C] == 0 ? cnt + 1 : cnt;
		for (int cur = K; cur < N + K; cur++) {
			int head = graphs[(cur - K) % N];
			int tail = graphs[cur % N];
			
			--visited[head];
			if (visited[head] == 0) --cnt;
			
			++visited[tail];
			if (visited[tail] == 1) ++cnt;
			
			int res = visited[C] == 0 ? cnt + 1 : cnt;
			ans = Math.max(ans, res);
		}
		
		System.out.println(ans);
	}
}