import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int R, C, answer = 0;
	static char[][] graphs;
	static int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }};

	public static void main(String[] args) throws IOException {
		init();
		backtracking(0, 0, 1 << graphs[0][0] - 'A', 1);
		System.out.println(answer);
	}

	static void init() throws IOException { 
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		graphs = new char[R][C];
		for (int i = 0; i < R; i++) {
			graphs[i] = br.readLine().toCharArray();
		}
	}

	static void backtracking(int r, int c, int flag, int size) {
		if (size > answer) answer = size;
		
		for (int[] d : DIRECTIONS) {
			int nx = r + d[0], ny = c + d[1];
			
			if (!(0 <= nx && nx < R && 0 <= ny && ny < C)) continue;
			
			int current = graphs[nx][ny] - 'A';
			if ((flag & (1 << current)) == 0) backtracking(nx, ny, flag | 1 << current, size + 1);
		}
	}
}