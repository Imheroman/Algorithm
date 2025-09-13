import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	static int N, M, ans;
	static List<Integer>[] planes;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			init();
			solve();
		}
		System.out.println(sb);
	}
	

	static void init() throws IOException {
		ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		planes = new List[N + 1];
		parents = new int[N + 1];
		
		for (int i = 0; i < N + 1; i++) {
			parents[i] = i;
			planes[i] = new ArrayList<>();
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			planes[a].add(b);
		}
	}
	
	static void solve() {
		for (int i = 1; i < N + 1; i++) {
			if (planes[i].isEmpty()) continue;  // 연결된 노선이 ? 비행기가 ? 없으면 continue
			for (int p : planes[i]) if (union(i, p)) ++ans;  // 연결이 가능하면 이어줌
		}
		
		sb.append(ans).append("\n");
	}	
	
	static int find(int cur) {  // 최상위 부모를 찾아감 
		if (parents[cur] == cur) return cur;  // 내가 최상위 부모면 return
		return parents[cur] = find(parents[cur]);  // 계속 찾아감 
	}
	
	static boolean union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);
		
		if (aroot == broot) return false;  // 부모가 같은 경우에는 union 불가
		
		if (aroot > broot) parents[aroot] = broot;
		else parents[broot] = aroot;
		
		return true;
	}
}