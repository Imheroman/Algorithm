import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	static int[] numbers;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static ArrayDeque<Integer> repository = new ArrayDeque<>();  

	public static void main(String[] args) throws IOException {
		init();
		solve();
		System.out.println(sb);
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);
	}
	
	public static void solve() {
		if (repository.size() == M) {
			for (int number : repository) {
				sb.append(number).append(" ");
			}
			sb.append("\n");
		}
		
		for (int i = 0; i < N; i++) {
			if (repository.contains(numbers[i])) {
				continue;
			}
			
			repository.offer(numbers[i]);
			solve();
			repository.pollLast();
		}
	}
}