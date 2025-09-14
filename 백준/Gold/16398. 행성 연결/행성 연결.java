import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
    static long ans;
	static int N;
	static List<Node>[] nodes;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
		prim();
		System.out.println(ans);			
	}
	

	static void init() throws IOException {
		ans = 0;
		
		N = Integer.parseInt(br.readLine());
		
		nodes = new List[N + 1];
		for (int i = 0; i < N + 1; i++) nodes[i] = new ArrayList<>();
		
		StringTokenizer st;
		for (int from = 1; from < N + 1; from++) {
			st = new StringTokenizer(br.readLine());
			for (int to = 1; to < N + 1; to++)
				nodes[from].add(new Node(to, Integer.parseInt(st.nextToken())));
		}
	}
	
	static void prim() {
		Queue<Node> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];
		
		queue.offer(new Node(1, 0));  // 1부터 시작한다고 임의로 배정
		
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if (visited[cur.to]) continue;  // 방문한 적 있는 노드면 continue
            
			visited[cur.to] = true;  // 방문한 적 없는 노드면 방문 처리 후
			ans += cur.weight;  // 비용 증가
			
			for (Node node : nodes[cur.to]) {  // 현재 방문한 노드에서 방문할 수 있는 노드들 찾기
				if (visited[node.to]) continue;  // 만약 방문했으면 갈 필요 없음
				queue.offer(node);  // 방문 안 한 노드들 다 queue에 추가 -> PQ로 최소 비용 관리
			}
		}
	}

	static class Node implements Comparable<Node>{
		int to, weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}