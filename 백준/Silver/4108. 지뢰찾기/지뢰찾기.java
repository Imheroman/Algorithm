import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb;
	static int[][] DIRECTIONS = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}
	

	static void init() throws IOException {
		sb = new StringBuilder();
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
			
			if (R == 0 && C == 0) break;
			
			char[][] graphs = new char[R][C];
			for (int i = 0; i < R; i++) {
				String items = br.readLine();
				for (int j = 0; j < C; j++) graphs[i][j] = items.charAt(j); 
			}
			
			solve(graphs, R, C);			
		}
		System.out.println(sb);
	}
	
	static void solve(char[][] graphs, int R, int C) {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) 
				sb.append(graphs[r][c] == '*' ? "*" : String.valueOf(count(graphs, r, c, R, C)));
			sb.append("\n");
		}
	}
	
	static int count(char[][] graphs, int r, int c, int R, int C) {
		int sum = 0;
		
		for (int[] d : DIRECTIONS) {
			int nx = r + d[0], ny = c + d[1];
			if (0 <= nx & nx < R && 0 <= ny && ny < C && graphs[nx][ny] == '*') ++sum;
		}
		
		return sum;
	}
}