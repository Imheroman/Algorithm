import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int N, M;
	static int[] numbers, repository;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
		permutation(0);
		System.out.println(sb);
	}

	public static void init() throws IOException {  // 입력 받기
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		repository = new int[M];
		
		st = new StringTokenizer(br.readLine());
		numbers = new int[N];
		for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(numbers);
	}
	
	public static void permutation(int depth) {
		if (depth == M) {
			for (int number : repository) sb.append(number).append(" ");
			sb.append("\n");
			return;
		}

		for (int number : numbers) {
			repository[depth] = number;
			permutation(depth + 1);
		}
	}
}