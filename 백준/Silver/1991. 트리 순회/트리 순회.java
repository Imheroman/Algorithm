import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	static char[][] graphs;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		init();
		solve();
		System.out.println(sb);
	}

	public static void init() throws IOException {
		int n = Integer.parseInt(br.readLine());
		graphs = new char[n][2];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0), left = st.nextToken().charAt(0), right = st.nextToken().charAt(0);
			graphs[root - 'A'][0] = left;
			graphs[root - 'A'][1] = right;
		}
	}

	public static void solve() {
		preorder(0);
		sb.append("\n");
		inorder(0);
		sb.append("\n");
		postorder(0);
		sb.append("\n");
	}
	
	public static void preorder(int current) {
		sb.append((char) (current + 'A'));
		if (graphs[current][0] != '.') {
			preorder(graphs[current][0] - 'A');
		}
		if (graphs[current][1] != '.') {
			preorder(graphs[current][1] - 'A');
		}
	}
	
	public static void inorder(int current) {
		if (graphs[current][0] != '.') {
			inorder(graphs[current][0] - 'A');
		}
		sb.append((char) (current + 'A'));
		if (graphs[current][1] != '.') {
			inorder(graphs[current][1] - 'A');
		}
	}
	
	public static void postorder(int current) {
		if (graphs[current][0] != '.') {
			postorder(graphs[current][0] - 'A');
		}
		if (graphs[current][1] != '.') {
			postorder(graphs[current][1] - 'A');
		}
		sb.append((char) (current + 'A'));
	}
}