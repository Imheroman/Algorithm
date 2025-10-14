import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
        
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		for (int i = 1; i < N + 1; i++) queue.offer(i);
        
		solve(queue);
	}

	static void solve(ArrayDeque<Integer> queue) {
		while (queue.size() > 1) {
			queue.poll();
			queue.offerLast(queue.poll());
		}
		
		System.out.println(queue.poll());
	}
}