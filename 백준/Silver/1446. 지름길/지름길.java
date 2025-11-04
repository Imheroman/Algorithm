import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static final int GRAPH_SIZE = 10_005;
	static int N, D;
	static List<int[]>[] graphs;
		
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		graphs = new List[GRAPH_SIZE];
		for (int i = 0; i < GRAPH_SIZE; i++) {
			graphs[i] = new ArrayList<>();
			graphs[i].add(new int[] {i + 1, 1});
		}
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()),
					to = Integer.parseInt(st.nextToken()),
					cost = Integer.parseInt(st.nextToken());
			
			if (to > D) continue;
			graphs[from].add(new int[] {to, cost});
		}
		
		solve();
	}
  
	// dijkstra로 해결한다면 ? 거리가 먼 순, 거리가 동일하면 ? cost가 낮은 순 ? / 아니면 그냥 cost가 낮은 순 ?
	static void solve() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {0, 0});
		
		int[] costs = new int[GRAPH_SIZE * 2];
		Arrays.fill(costs, 1_999_999_999);
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			if (cur[0] > D) continue;
			
			for (int[] near : graphs[cur[0]]) {
				if (costs[near[0]] > cur[1] + near[1]) {
					costs[near[0]] = cur[1] + near[1];
					queue.offer(new int[] {near[0], cur[1] + near[1]});
				}
			}
		}
		System.out.println(costs[D]);
	}
}