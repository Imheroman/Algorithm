import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	static ArrayDeque<Integer> repository = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = getInt(st), M = getInt(st);
		recur(N, M);
		System.out.println(sb);
	}
	
	public static void recur(int n, int m) {
		if (repository.size() >= m) {
			repository.forEach(number -> sb.append(number).append(" "));
			sb.append("\n");
			return;
		}
		
		for (int number = 1; number <= n; number++) {
			if (!repository.contains(number)) {
				repository.offer(number);
				recur(n, m);
				repository.pollLast();
			}
		}
	} 

	public static int getInt(StringTokenizer s) {
		return Integer.parseInt(s.nextToken());
	}
}