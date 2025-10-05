import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	static void init() throws IOException {
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()),
				M = Integer.parseInt(st.nextToken()),
				K = Integer.parseInt(st.nextToken()),
				X = Integer.parseInt(st.nextToken());
		
		List<Integer>[] graphs = new List[N + 1];
		for (int i = 0; i < N + 1; i++) graphs[i] = new ArrayList<>();
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()),
				 to = Integer.parseInt(st.nextToken());
			
			graphs[from].add(to);
		}
		
		solve(graphs, K, X);
	}
	
	static void solve(List<Integer>[] graphs, int K, int X) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[graphs.length];
		Set<Integer> ans = new TreeSet<>();
		
		queue.offer(new int[] {X, 0});
		visited[X] = true;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for (int next : graphs[cur[0]]) {
				if (visited[next]) continue;
				
				visited[next] = true;
				if (cur[1] + 1 == K) ans.add(next);
				else queue.offer(new int[] {next, cur[1] + 1});
			}
		}
		
		if (ans.isEmpty()) System.out.println("-1");
		else {
			for (int num : ans) sb.append(num).append("\n");
			System.out.println(sb);
		}
	}
}