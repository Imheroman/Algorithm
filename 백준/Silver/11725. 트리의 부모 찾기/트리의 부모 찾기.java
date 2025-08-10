import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	static int N;
	static StringBuilder sb = new StringBuilder();
	static List<Integer>[] graphs;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		for (int i = 2; i <= N; i++) {
			sb.append(answer[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		graphs = new List[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graphs[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken());
			graphs[from].add(to);
			graphs[to].add(from);
		}
		
		answer = new int[N + 1];
	}
	
	public static void solve() {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			
			for (int number : graphs[current]) {
				if (!visited[number]) {
					answer[number] = current;
					queue.offer(number);
					visited[number] = true;
				}
			}
		}
	}
}