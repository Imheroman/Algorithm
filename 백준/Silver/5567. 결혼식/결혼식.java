import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] graphs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int N = Integer.parseInt(br.readLine()),
				M = Integer.parseInt(br.readLine());
		
		graphs = new List[N + 1];
		for (int i = 0; i < N + 1; i++) graphs[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken()),
					p2 = Integer.parseInt(st.nextToken());
			
			graphs[p1].add(p2);
			graphs[p2].add(p1);
		}
		
		bfs(N, M);
	}
	
	static void bfs(int N, int M) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] {0, 1});
		
		boolean[] visited = new boolean[N + 1];
		visited[1] = true;
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			
			for (int next : graphs[current[1]]) {
				if (visited[next] || current[0] > 1) continue;
				
				++cnt;
				queue.offer(new int[] {current[0] + 1, next});
				visited[next] = true;
			}
		}
		
		System.out.println(cnt);
	}
}