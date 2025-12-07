import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br; 
	static StringBuilder sb = new StringBuilder();
	static ArrayDeque<Integer> stack = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	private static void init() throws IOException {
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) solve(new StringTokenizer(br.readLine()));
		
		System.out.println(sb);
	}

	private static void solve(StringTokenizer st) {
		
		int command = Integer.parseInt(st.nextToken());
		
		if (command == 1) {
			stack.offer(Integer.parseInt(st.nextToken()));
			return;
		}
		else if (command == 2) sb.append(stack.isEmpty() ? -1 : stack.pollLast());
		else if (command == 3) sb.append(stack.size());
		else if (command == 4) sb.append(stack.isEmpty() ? 1 : 0);
		else sb.append(stack.isEmpty() ? -1 : stack.peekLast());
		
		sb.append("\n");
	}
}