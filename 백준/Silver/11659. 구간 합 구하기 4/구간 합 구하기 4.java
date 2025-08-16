import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		init();
		solve();
		System.out.println(sb);
	}

	static void init() throws IOException { // 입력 받는 메소드입니다.
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			numbers[i] = numbers[i - 1] + Integer.parseInt(st.nextToken());
		}
	}

	static void solve() throws IOException {
		for (int t = 0; t < M; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int pre = Integer.parseInt(st.nextToken()) - 1, post = Integer.parseInt(st.nextToken());
			sb.append(numbers[post] - numbers[pre]).append("\n");
		}
	}
}