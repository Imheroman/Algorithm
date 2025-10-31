import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	static void init() throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] commands = new int[N];
		for (int i = 0; i < N; i++) commands[i] = Integer.parseInt(br.readLine());
		
		solve(commands);
	}
 
	static void solve(int[] commands) {
		Queue<Integer> queue = new PriorityQueue<>();
		
		for (int command : commands) {
			if (command == 0) sb.append(queue.isEmpty() ? 0 : queue.poll() * -1).append("\n");
			else queue.offer(command * -1);
		}
		
		System.out.println(sb);
	}
}