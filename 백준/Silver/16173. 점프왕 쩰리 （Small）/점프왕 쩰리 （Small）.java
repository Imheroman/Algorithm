import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 } };
	private static final int X = 0;
	private static final int Y = 1;

	public static void main(String[] args) throws IOException {
		int N = getInt();
		int[][] graphs = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = input();
			for (int j = 0; j < N; j++) {
				graphs[i][j] = getInt(st);
			}
		}
		String answer = "Hing";

		boolean[][] visited = new boolean[N][N];
		Queue<Integer[]> needVisited = new ArrayDeque<>();
		needVisited.add(new Integer[] { 0, 0 });
		visited[0][0] = true;

		while (!needVisited.isEmpty() && answer.equals("Hing")) {
			Integer[] current = needVisited.poll();
			int jump = graphs[current[X]][current[Y]];

			for (int[] direction : DIRECTIONS) {
				int row = current[X] + direction[X] * jump;
				int col = current[Y] + direction[Y] * jump;

				if ((0 <= row && row < N && 0 <= col && col < N) && !visited[row][col]) {
					if (row == N - 1 && col == N - 1) {
						answer = "HaruHaru";
						break;
					}

					needVisited.add(new Integer[] { row, col });
					visited[row][col] = true;
				}
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

	public static int getInt() throws IOException {
		return Integer.parseInt(br.readLine());
	}
}