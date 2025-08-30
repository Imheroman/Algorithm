import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb;
	static int N; 
	static int[][] graphs;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
		dfs(0, 0, N);
		System.out.println(sb);
	}
	
	public static void init() throws IOException {  // 입력 받기
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		graphs = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < N; j++)
				graphs[i][j] = line.charAt(j) - '0';
		}
	}
	
	public static void dfs(int x, int y, int limit) {  // dfs
		 int res = check(x, y, limit);  // 현재 탐색 가능한 범위에서 전체 값 탐색 후 결과값
		 
		 if (res != -1) sb.append(res);  // 만약 모두 동일한 값이면 그대로 ~ 넣기
		 else {  // 서로 다른 값이면 == -1
           sb.append("(");  // 괄호 열고 들어가서 
           int size = limit / 2;  // 탐색 범위 반으로 줄여주고
           dfs(x, y, size);  // 4분면 모두 이동
           dfs(x, y + size, size);
           dfs(x + size, y, size);
           dfs(x + size, y + size, size);
           sb.append(")");  // 끝나면 괄호 닫기
         }
		 return;
	}
	
	public static int check(int x, int y, int limit) {  // 모두 1인지 확인
		int res = 0;
		
		for (int i = x; i < x + limit; i++)
			for (int j = y; j < y + limit; j++)
				res += graphs[i][j];  // 그래프의 전체 값 더함
		
		if (res == 0) return 0;  // 모두 더했을 때 0이면 == 0만 있음
		else if (res == limit * limit) return 1;  // == limit의 제곱만큼 있으면 == 1만 있음
		else return -1;  // == 아니면 섞임
	}
}