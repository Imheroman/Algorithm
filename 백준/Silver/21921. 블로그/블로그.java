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
		for (int i = 1; i < N + 1; i++) visited[i] = Integer.parseInt(st.nextToken()) + visited[i - 1];
		
		solve();
	}
	
	static void solve() {
		int max = 0, cnt = 0;
		for (int i = 0; i < N - X + 1; i++) {
			int sum = visited[i + X] - visited[i];
			
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
