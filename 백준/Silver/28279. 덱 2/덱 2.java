import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br; 
	static StringBuilder sb = new StringBuilder();
	
	static Deque<Integer> deque = new ArrayDeque<>();

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
			deque.offerFirst(Integer.parseInt(st.nextToken()));
			return;
		}
		else if (command == 2) {
			deque.offer(Integer.parseInt(st.nextToken()));
			return;
		}
		else if (command == 3) sb.append(deque.isEmpty() ? -1 : deque.poll());
		else if (command == 4) sb.append(deque.isEmpty() ? -1 : deque.pollLast());
		else if (command == 5) sb.append(deque.size());
		else if (command == 6) sb.append(deque.isEmpty() ? 1 : 0);
		else if (command == 7) sb.append(deque.isEmpty() ? -1 : deque.peek());
		else if (command == 8) sb.append(deque.isEmpty() ? -1 : deque.peekLast());
		
		sb.append("\n");
	}
}