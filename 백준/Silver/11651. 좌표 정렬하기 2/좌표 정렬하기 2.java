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
		Set<int[]> numbers = new TreeSet<>((pre, post) -> pre[1] != post[1] ? 
				Integer.compare(pre[1], post[1]) : Integer.compare(pre[0], post[0]));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()),
					y = Integer.parseInt(st.nextToken());
			numbers.add(new int[] {x, y});
		}
		
		solve(numbers);
	}
	
	static void solve(Set<int[]> numbers) {
		for (int[] number : numbers) 
			sb.append(number[0]).append(" ").append(number[1]).append("\n");
		
		System.out.println(sb);
	}
}