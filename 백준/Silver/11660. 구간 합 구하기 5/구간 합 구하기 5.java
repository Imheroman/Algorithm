import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb;
	static int[][] memoization;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	static void init() throws IOException {
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		memoization = new int[N + 1][N + 1];
		
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++)
				memoization[i][j] = memoization[i][j - 1] + Integer.parseInt(st.nextToken()); 
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()),
					x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());
			solve(x1, y1, x2, y2);
		}
		
		System.out.println(sb);
	}
	
	static void solve(int x1, int y1, int x2, int y2) {
		int sum = 0;
		for (int x = x1; x <= x2; x++)
			sum += memoization[x][y2] - memoization[x][y1 - 1];
		
		sb.append(sum).append("\n");
	}
}