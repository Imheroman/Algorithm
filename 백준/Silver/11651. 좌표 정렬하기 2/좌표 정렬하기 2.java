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
		int n = Integer.parseInt(br.readLine());
		int[][] numbers = new int[n][];
		
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()),
					y = Integer.parseInt(st.nextToken());
			numbers[i] = new int[] {x, y};
		}
		
		solve(numbers, n);
	}
	
	static void solve(int[][] numbers, int n) {
		Arrays.sort(numbers, (pre, post) -> pre[1] != post[1] ? 
				Integer.compare(pre[1], post[1]) : Integer.compare(pre[0], post[0]));
		
		for (int[] number : numbers) 
			sb.append(number[0]).append(" ").append(number[1]).append("\n");
		
		System.out.println(sb);
	}
}