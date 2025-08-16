import java.io.*;
import java.util.*;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static int N, answer;
	static int[][] graphs;
	static int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}, 
			BLOCK_DIRECTIONS = new int[][] {{}, 
		{2, 0, 3, 1},
		{2, 3, 1, 0},
		{1, 3, 0, 2},
		{3, 2, 0, 1},
		{2, 3, 0, 1}};
	static Map<Integer, List<int[]>> wormholes;

	public static void main(String[] args) throws IOException {
//		int t = Integer.parseInt(br.readLine());
		int t = sc.nextInt();

		for (int tcase = 1; tcase <= t; tcase++) {
			init();
			solve();
			System.out.println(String.format("#%d %d", tcase, answer));
		}
	}

	static void init() throws IOException {
		answer = 0;
		N = sc.nextInt();
		
		wormholes = new HashMap<>();
		graphs = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				graphs[i][j] = sc.nextInt();
				
				if (graphs[i][j] > 5) {
					wormholes.putIfAbsent(graphs[i][j], new ArrayList<>());
					wormholes.get(graphs[i][j]).add(new int[] {i, j});
				}
			}
		}
	}

	static void solve() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (graphs[i][j] == 0) {
					for (int d = 0; d < DIRECTIONS.length; d++)  game(new Ball(i, j, d), i, j);
				}
			}
		}
	}
	
	private static void game(Ball ball, int r, int c) {
		while (true) {
			ball.move();
			int bx = ball.x;
			int by = ball.y;
			
			if (isWall(ball)) {
				++ball.count;
				ball.d = (ball.d + 2) % DIRECTIONS.length;
				continue;
			} 
			
			int current = graphs[bx][by];
			if ((bx == r && by == c) || current == -1) break;
			
			if (1 <= current && current <= 5) {
				++ball.count;
				ball.d = BLOCK_DIRECTIONS[current][ball.d];
			} else if (5 < current) { // wormhole
				for (int[] pos : wormholes.get(current)) {
					if (pos[0] != bx || pos[1] != by) {
						ball.x = pos[0];
						ball.y = pos[1];
					}
				}
			} 
		}
		
		answer = answer > ball.count ? answer : ball.count;
	}

	static class Ball {
		int x, y, d, count;
		
		public Ball(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.count = 0;
		}
		
		public void move() {
			this.x += DIRECTIONS[d][0];
			this.y += DIRECTIONS[d][1];
		}
		
		int getNx() {
			return this.x + DIRECTIONS[this.d][0];
		}
		
		int getNy() {
			return this.y + DIRECTIONS[this.d][1];
		}
	}

	public static boolean isValidRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
	
	static boolean isWall(Ball ball) {
		return !isValidRange(ball.x, ball.y);
	}
}