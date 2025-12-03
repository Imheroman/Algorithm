import java.io.*;
import java.util.*;

// 블로그 보고 짠 코드
public class Main {
	private static BufferedReader br; 
	static StringBuilder[] sb;
	static int[] buildings;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	private static void init() throws IOException {		
		int N = Integer.parseInt(br.readLine());
		sb = new StringBuilder[N];
		for (int i = 0; i < N; i++) sb[i] = new StringBuilder();
		
		int totalSize = (int) Math.pow(2, N) - 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		buildings = new int[totalSize];
		for (int i = 0; i < totalSize; i++) buildings[i] = Integer.parseInt(st.nextToken());
		
		tree(0, totalSize - 1, 0);  // 0 ~ 6까지 접근 가능하니까 -1
		for (StringBuilder s : sb) {
			System.out.println(s);
		}
	}
	
	static void tree(int start, int end, int depth) {
		if (start > end) return;
		
		int mid = (start + end) / 2;

		sb[depth].append(buildings[mid]).append(" ");  // depth별로 나눠서 저		
		tree(start, mid - 1, depth + 1);  // 왼쪽부터 탐색한다고 했으니 왼쪽부터 탐색 !
		tree(mid + 1, end, depth + 1);
	}
}