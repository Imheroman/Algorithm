import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br; 
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) init();
		
		System.out.println(sb);
	}

	private static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()),
			K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] candy = new int[N];
		for (int i = 0; i < N; i++) candy[i] = Integer.parseInt(st.nextToken());
		
		solve(candy, K);
	}

	private static void solve(int[] candy, int k) {
		int answer = 0;
		for (int c : candy) answer += c / k;
		
		sb.append(answer).append("\n");
	}
}