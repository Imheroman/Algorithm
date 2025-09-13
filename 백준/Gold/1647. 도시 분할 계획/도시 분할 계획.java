import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static int N, M, ans;
	static Edge[] edges;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		System.out.println(ans);			
	}
	

	static void init() throws IOException {
		ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		edges = new Edge[M];
		parents = new int[N + 1];
		
		for (int i = 0; i < N + 1; i++) parents[i] = i;
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()),
					to = Integer.parseInt(st.nextToken()),
					w = Integer.parseInt(st.nextToken());
			
			edges[m] = new Edge(from, to, w);
		}
		
		Arrays.sort(edges);
	}
	
	static void solve() {
		int cnt = 0;
		
		for (Edge e : edges) {
			if (cnt == N - 2) break;  // 간선의 수이기 때문에 N - 1
			if (!union(e.from, e.to)) continue;  // 이미 서로 같은 조상이라면 Pass
			
			++cnt;
			ans += e.weight;
		}
	}	
	
	static int find(int cur) {  // 최상위 부모를 찾아감 
		if (parents[cur] == cur) return cur;  // 내가 최상위 부모면 return
		return parents[cur] = find(parents[cur]);  // 계속 찾아감 
	}
	
	static boolean union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);
		
		if (aroot == broot) return false;  // 부모가 같은 경우에는 union 불가
		
        // 더 작은 쪽으로 붙여주기
		if (aroot > broot) parents[aroot] = broot;
		else parents[broot] = aroot;
		
		return true;
	}
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Main.Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}