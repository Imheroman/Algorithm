import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static int N, M, ans;
	static List<Node>[] nodes;
	static Node startNode;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		prim();
		System.out.println(ans);			
	}
	

	static void init() throws IOException {
		ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nodes = new List[N + 1];
		for (int i = 0; i < N + 1; i++) nodes[i] = new ArrayList<>();
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken()),
					to = Integer.parseInt(st.nextToken()),
					weight = Integer.parseInt(st.nextToken());

            // 양방향으로 이어주기
			nodes[from].add(new Node(to, weight));
			nodes[to].add(new Node(from, weight));
		}
	}
	
	static void prim() {
		Queue<Node> queue = new PriorityQueue<Main.Node>();
		boolean[] visited = new boolean[N + 1];
		
		queue.offer(new Node(1, 0)); // 임의 정점 삽입 (시작 정점이므로 cost == 0)
		
		int max = 0;  // 최댓값 저장
		while (!queue.isEmpty()) {  // 큐에 데이터가 있으면 계속
			Node node = queue.poll();  // 가장 최소 거리 가져오기
			
			if (visited[node.to]) continue;  // 방문한 적 있는 노드면 pass
			
			visited[node.to] = true;  // 방문 처리
			ans += node.weight;  // 거리 누적
			if (max < node.weight) max = node.weight;  // max값 더하기
			
			for (Node n : nodes[node.to]) { // 현재 방문 노드에서 갈 수 있는 모든 노드들에 대해
				if (visited[n.to]) continue;  // 방문했으면 pass
				queue.offer(n);  // 방문 안 했으면 일단 다 넣기 (최솟값을 PQ로 구하기 때문에)
			}
		}
      
		ans -= max;  // 최댓값 빼주기
	}	
	
	static class Node implements Comparable<Node>{
		int to, weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Main.Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}