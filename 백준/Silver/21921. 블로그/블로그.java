import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br; 
	
	static int X, N;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	private static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		visited = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) visited[i] = Integer.parseInt(st.nextToken());
		
		solve();
	}
	
	static void solve() {
		int sum = 0;
		for (int i = 0; i < X; i++) sum += visited[i];
		
		int max = sum, cnt = 1;
		for (int i = X; i < N; i++) {
			sum += visited[i] - visited[i - X];
			
			if (sum == max) ++cnt;
			else if (sum > max) {
              cnt = 1;
              max = sum;
            }
		}
		
		if (max == 0) System.out.println("SAD");
		else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}
}
