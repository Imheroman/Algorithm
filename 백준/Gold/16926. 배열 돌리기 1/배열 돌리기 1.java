import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static final int COMMON_SPACE_SIZE = 2;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = getInt(st), m = getInt(st), r = getInt(st);
		
		int[][] arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = getInt(st);
			}
		}
        
		rotate(arr, n, m, r);
		
		for (int[] row : arr) {
			for(int number : row) {
				System.out.print(number + " ");
			}
			System.out.println();
		}
	}
	
	private static void rotate(int[][] arr, int n, int m, int r) {
		int[][] copy = new int[n][m];
		int range = Math.min(n,  m) / 2;
		
		for (int start = 0; start < range; start++) {
			List<Integer> repository = new ArrayList();
			
			for (int i = start; i < n - start; i++) {
				repository.add(arr[i][start]);
			}
			
			for (int col = start + 1; col < m - start; col++) {
				repository.add(arr[n - start - 1][col]);
			}
			
			for (int row = n - start - COMMON_SPACE_SIZE; row >= start; row--) {
				repository.add(arr[row][m - start - 1]);
			}
			
			for (int col = m - start - COMMON_SPACE_SIZE; col > start; col--) {
				repository.add(arr[start][col]);
			}
			
			int rotations = r % repository.size();
		    Collections.rotate(repository, rotations);
			int index = 0;
			
			for (int i = start; i < n - start; i++, index++) {
				arr[i][start] = repository.get(index % repository.size());
			}
			
			for (int col = start + 1; col < m - start; col++, index++) {
				arr[n - start - 1][col] = repository.get(index % repository.size());
			}
			
			for (int row = n - start - COMMON_SPACE_SIZE; row >= start; row--, index++) {
				arr[row][m - start - 1] = repository.get(index % repository.size());
			}
			
			for (int col = m - start - COMMON_SPACE_SIZE; col > start; col--, index++) {
				arr[start][col] = repository.get(index % repository.size());
			}
		}
	}

	public static int getInt(StringTokenizer s) {
		return Integer.parseInt(s.nextToken());
	}
	
	public static int getInt() throws IOException {
		return Integer.parseInt(br.readLine());
	}
}