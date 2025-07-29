import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = input();
		int N = getInt(st), M = getInt(st);
		int[] numbers = new int[N];
		st = input();
		
		for (int i = 0; st.hasMoreTokens() && i < N; i++) {
			numbers[i] = getInt(st);
		}
		
		int l = 0, r = 1, answer = 0;
		
		while (l <= r && r <= N) {
			int sum = 0;
			
			for (int i = l; i < r; i++) {
				sum += numbers[i];
			}
			
			if (sum > M) {
				l++;
			} else if (sum == M) {
				r++;
				l++;
				answer++;
			} else {
				r++;
			}
		}
		
		System.out.println(answer);
	}

	public static StringTokenizer input() throws IOException {
		return new StringTokenizer(br.readLine());
	}

	public static int getInt(StringTokenizer s) {
		return Integer.parseInt(s.nextToken());
	}
}