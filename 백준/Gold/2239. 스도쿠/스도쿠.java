import java.io.*;
import java.util.*;

public class Main {
	static final int SUDOKU_GRAPH_SIZE = 9;
	static int[][] graphs = new int[SUDOKU_GRAPH_SIZE][SUDOKU_GRAPH_SIZE];
	static List<int[]> resources = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < SUDOKU_GRAPH_SIZE; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < SUDOKU_GRAPH_SIZE; j++) {
				graphs[i][j] = line.charAt(j) - '0';
				if (graphs[i][j] == 0) resources.add(new int[] {i, j});
			}
		}
		
		sudoku(0);
	}
	
	static void sudoku(int depth) {
		if (resources.size() == depth) {
			for (int[] g : graphs) {
				for (int num : g) System.out.print(num);
				System.out.println();
			}
			System.exit(0);
		}
		
		int[] pos = resources.get(depth);
		int x = pos[0], y = pos[1];
		for (int val = 1; val < 10; val++) {
			graphs[x][y] = val;
			if (isMatch(x, y)) sudoku(depth + 1);
			graphs[x][y] = 0;
		}
	}
	
	static boolean isMatch(int x, int y) {
		// x, y 검사 
		for (int i = 0; i < SUDOKU_GRAPH_SIZE; i++) {
			if (graphs[x][i] == graphs[x][y] && i != y)  // 세로 검사 == col 검사
				return false;  
			
			if (graphs[i][y] == graphs[x][y] && i != x)  // 가로 검사 == row 검사
				return false;
		}
		
		// box 검사
		int row = (x / 3) * 3, col = (y / 3) * 3; 
		for (int r = row; r < row + 3; r++) {
			for (int c = col; c < col + 3; c++) {
				if (graphs[x][y] == graphs[r][c] && x != r && y != c)
					return false;
			}
		}
		
		return true;
	}
}