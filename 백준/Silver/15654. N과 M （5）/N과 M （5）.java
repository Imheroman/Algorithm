import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	static int[] numbers;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int[] repository;

	public static void main(String[] args) throws IOException {
		init();
		solve(new boolean[N], 0);
		System.out.println(sb);
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		repository = new int[M]; 
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);
	}
	
	public static void solve(boolean[] selected, int depth) {
		if (depth == M) {
			for (int number : repository) {
				sb.append(number).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (selected[i]) {
				continue;
			}
			
			repository[depth] = numbers[i];
			selected[i] = true;
			solve(selected, depth + 1);
			selected[i] = false;
		}
	}
}