import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	static void init() throws IOException {
		sb = new StringBuilder();
		Queue<Integer> numbers = new PriorityQueue<>(Comparator.naturalOrder()); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) 
			numbers.offer(Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) 
			numbers.offer(Integer.parseInt(st.nextToken()));
		
		solve(numbers);
	}
	
	static void solve(Queue<Integer> numbers) {
		while (!numbers.isEmpty()) sb.append(numbers.poll()).append(" ");
		
		System.out.println(sb);
	}
}