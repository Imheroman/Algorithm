import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	static int N;
	static StringBuilder sb = new StringBuilder();
	static int[] numbers;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		System.out.println(sb);
	}
	
	public static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		
		for (int i = 0; i < N; i++)  {
			numbers[i] = Integer.parseInt(br.readLine());
		}
	}
	
	public static void solve() {
		Deque<Integer> stack = new ArrayDeque<>();
		int num = 1, cur = 0;
		
		for (int number = 1; number <= N; number++) {
			sb.append("+").append("\n");
			stack.push(number);

			while(!stack.isEmpty() && stack.peek() == numbers[cur]) {
				stack.pop();
				cur++;
				sb.append("-").append("\n");
			}
		}
		
		if (!stack.isEmpty()) {
			sb.setLength(0);
			sb.append("NO");
		}
	}
}