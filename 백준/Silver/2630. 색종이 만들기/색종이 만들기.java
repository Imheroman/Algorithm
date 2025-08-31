import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static int N;
	static int[] ans;
	static int[][] graphs;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
		dfs(0, 0, N);
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}

	public static void init() throws IOException {  // 입력 받기
		ans = new int[] {0, 0};
		
		N = Integer.parseInt(br.readLine());
		graphs = new int[N][N];
        
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++)
				graphs[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	public static void dfs(int x, int y, int limit) {  // dfs
		 int res = check(x, y, limit);  // 현재 탐색 가능한 범위에서 전체 값 탐색 후 결과값
		 
		 if (res != -1) ++ans[res];// 만약 모두 동일한 값이면 그대로 ~ 넣기
		 else {  // 서로 다른 값이면 == -1
           int size = limit / 2;  // 탐색 범위 반으로 줄여주고
           dfs(x, y, size);  // 4분면 모두 이동
           dfs(x, y + size, size);
           dfs(x + size, y, size);
           dfs(x + size, y + size, size);
         }
		 
		 return;
	}
	
	public static int check(int x, int y, int limit) {  // 모두 1인지 확인
		int init = graphs[x][y];
		
		for (int i = x; i < x + limit; i++)
			for (int j = y; j < y + limit; j++)
				if (init != graphs[i][j]) return -1;
		
		return init;
	}
}