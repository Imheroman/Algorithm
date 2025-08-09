import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	static int[] repository;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = getInt(st), M = getInt(st);
		repository = new int[M];
		recur(new boolean[N + 1], N, M, 1, 0);
		System.out.println(sb);
	}
	
	public static void recur(boolean[] selected, int n, int m, int start, int depth) {
		if (depth >= m) {
			for (int number : repository) {
				sb.append(number).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int current = start; current <= n; current++) {
			if (!selected[current]) {
				selected[current] = true;
				repository[depth] = current;
				recur(selected, n, m, current, depth + 1);
				selected[current] = false;
			}
		}
	} 

    public static int getInt(StringTokenizer s) {
		return Integer.parseInt(s.nextToken());
	}
}