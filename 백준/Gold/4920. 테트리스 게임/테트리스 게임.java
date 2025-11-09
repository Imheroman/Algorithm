import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    
    static final int MIN_VAL = -1_999_999_999;
    static final int[][][] DIRECTIONS = {
    		{{0, 1}, {0, 2}, {0, 3}}, {{1, 0}, {2, 0}, {3, 0}},  // 1자 모양
    		{{0, 1}, {1, 1}, {1, 2}}, {{1, 0}, {1, -1}, {2, -1}},  // -|_ 모양
    		{{0, 1}, {0, 2}, {1, 2}}, {{1, 0}, {2, 0}, {2, -1}}, {{1, 0}, {1, 1}, {1, 2}}, {{0, -1}, {1, -1}, {2, -1}},  // --| 모양
    		{{0, 1}, {0, 2}, {-1, 1}}, {{0, 1}, {1, 1}, {0, 2}}, {{0, 1}, {1, 0}, {-1, 0}}, {{0, -1}, {1, 0}, {-1, 0}},  // ㅗ 모양
    		{{0, 1}, {1, 0}, {1, 1}}  // ㅁ 모양
    };
    
    static int N;
    static int[][] graphs;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = -1;
        int t = 0;
        
        while (true) {
        	N = Integer.parseInt(br.readLine().trim());
        	if (N == 0) break;
        	
        	int res = init();
        	sb.append(++t).append(". ").append(res).append("\n");
        } 
        
        System.out.println(sb);
    }

    static int init() throws IOException {
    	graphs = new int[N][N];
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine().trim());
    		
    		for (int j = 0; j < N; j++) graphs[i][j] = Integer.parseInt(st.nextToken().trim());
    	}
    	
    	return solve();
    }
    
    static int solve() {
    	int max = MIN_VAL;
    	
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			for (int d = 0; d < DIRECTIONS.length; d++) {
    				int res = sum(i, j, DIRECTIONS[d]);
    				max = max > res ? max : res;
    			}
    		}
    	}
    	
    	return max;
    }
    
    static int sum(int x, int y, int[][] direction) {
    	int sum = graphs[x][y];
    	
    	for (int[] d : direction) {
    		int nx = x + d[0], ny = y + d[1];
    		
    		if (isValidRange(nx, ny)) sum += graphs[nx][ny];
    		else return MIN_VAL;
    	}
    	
    	return sum;
    }
    
    static boolean isValidRange(int x, int y) {
    	return 0 <= x && x < N && 0 <= y && y < N;
    }
}