import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static int N;
    static long ans;
	static int[] parents;
	static Edge[] edges;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		System.out.println(ans);			
	}
	

	static void init() throws IOException {
		ans = 0;
		
		N = Integer.parseInt(br.readLine());
		edges = new Edge[N * N];
		parents = new int[N + 1];
		
		StringTokenizer st;
		int cur = 0;
		for (int from = 1; from < N + 1; from++) {
			st = new StringTokenizer(br.readLine());
			for (int to = 1; to < N + 1; to++)
				edges[cur++] = new Edge(from, to, Integer.parseInt(st.nextToken()));  // edge 만들기
			
			parents[from] = from;  // 각 인덱스의 parents를 본인으로 설정
		}
		
		Arrays.sort(edges);  // 최소 비용의 간선을 얻기 위해 sort
	}
	
	static void solve() {
		int cnt = 0;
		for (Edge e : edges) {
			if (cnt == N - 1) break;  // 간선이 다 선택되면 break
			if (e.from == e.to || !union(e.from, e.to)) continue;  // 유니온 실패하면 continue
			ans += e.weight;  // 아직 선택되지 않은 노드가 나오면 weight 추가
			++cnt;  // 간선 추가
		}
	}
	
	static int find(int cur) {
		if (parents[cur] == cur) return cur;
		return parents[cur] = find(parents[cur]);
	}
	
	static boolean union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);
		
		if (aroot == broot) return false;
		
		if (aroot > broot) parents[aroot] = broot;  // aroot가 더 크면 aroot의 parent를 broot로
		else parents[aroot] = broot;  // broot가 더 크면 ? broot의 parent를 aroot로
		
		return true;  // union 성공
	}

	static class Edge implements Comparable<Edge> {  // 간선 정보를 저장하는 class
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}