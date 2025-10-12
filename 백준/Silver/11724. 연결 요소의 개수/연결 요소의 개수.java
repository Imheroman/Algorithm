import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()),
				M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] graphs = new List[N + 1];
		for (int i = 0; i < N + 1; i++) graphs[i] = new ArrayList<>();
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken()),
					n2 = Integer.parseInt(st.nextToken());
			
			graphs[n1].add(n2);
			graphs[n2].add(n1);
		}
		
		solve(graphs, N, M);
	}

	static void solve(List<Integer>[] graphs, int N, int M) {
		int ans = 0;
		boolean[] visited = new boolean[N + 1];
		
		for (int cur = 1; cur < N + 1; cur++) {
			if (visited[cur]) continue;
			++ans;
			
			bfs(graphs, visited, N, cur);
		}
		
		System.out.println(ans);
	}
	
	static void bfs(List<Integer>[] graphs, boolean[] visited, int N, int cur) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(cur);
		visited[cur] = true;
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			
			for (int node : graphs[now]) {
				if (visited[node]) continue;
				
				visited[node] = true;
				queue.offer(node);
			}
		}
	}
}