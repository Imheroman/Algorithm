import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br;
    static StringBuilder sb;
	static int V, E;
	static int[] inDegree;
	static Node[] nodes;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = 10;
		
		for (int tcase = 1; tcase <= t; tcase++) {
			init();
			solve(); 
			System.out.println(String.format("#%d %s", tcase, sb));
		}
	}
	
	static void init() throws IOException {
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		nodes = new Node[V + 1];
		inDegree = new int[V + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < E; i++) {
			int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken());
			nodes[from] = new Node(to, nodes[from]);
			++inDegree[to];
		}
	}
	
	static void solve() {
		Queue<Integer> queue = new ArrayDeque<>();
		
		for (int i = 1; i < V + 1; i++) {
			if (inDegree[i] == 0) queue.offer(i);
		}
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur).append(" ");
			
			for (Node node = nodes[cur]; !Objects.isNull(node); node = node.next) {
				if (--inDegree[node.val] == 0) queue.offer(node.val); 
			}
		}
	}

	static class Node {
		int val;
		Node next;
		
		public Node(int val, Node node) {
			this.val = val;
			this.next = node;
		}
	}
}
