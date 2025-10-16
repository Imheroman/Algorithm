import java.io.*;
import java.util.*;

/*
 * 입력들을 좌표로 입력받는다.
 * 
 * 동근이 위치에서 좌표까지의 거리를 구한 후
 * 사각형의 전체 길이를 구해서, 그 거리를 빼 최솟값을 비교한다.
 * 
 * 는 어렵게 풀릴 것 같아서 지피티의 아이디어 도움으로 그냥 왼위 꼭짓점에서 시작하는 걸로 생각하고 시계 방향으로 돈다고 생각하고 거리 계산해서 풀기
 */
public class Main {
	static BufferedReader br;
	static int W, H;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		
		int[] stores = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()), pos = Integer.parseInt(st.nextToken());
			stores[i] = assign(d, pos);
		}
		
		st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken()), pos = Integer.parseInt(st.nextToken());
		int dong = assign(d, pos);
		
		solve(stores, dong);
	}

	static void solve(int[] stores, int dong) {
		int ans = 0, total = (W + H) * 2;
		
		for (int store : stores) {
			int res = calPos(store, dong);
			ans += res < total - res ? res : total - res;   
		}
		
		System.out.println(ans);
	}
	
	private static int calPos(int store, int dong) {
		return Math.abs(store - dong);
	}

	static int assign(int d, int pos) {
		int res = 0;
      
		if (d == 1) res = pos;  // north	
		else if (d == 2) res = W + H + H - pos;  // south
		else if (d == 3) res = (W + H) * 2 - pos;  // west
		else res = H + pos;  // east
		
		return res;
	}
}