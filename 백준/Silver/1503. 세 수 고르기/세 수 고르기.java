import java.io.*;
import java.util.*;

// 지피티가 가지치기 알려준 코드 테스트
public class Main {
	static BufferedReader br;
	static final int MAX_NUMBER = 1_001, MAX_DEPTH = 3, MAX = 1_999_999_999;
	static int N, M, ans;
	static int[] numbers, repo;
	static Set<Integer> set;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	static void init() throws IOException {
		ans = MAX;
		set = new TreeSet<>(Comparator.naturalOrder());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[MAX_NUMBER - M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int number = Integer.parseInt(st.nextToken());
			set.add(number);
		}
		
		int number = 1;
		for (int i = 0; i < MAX_NUMBER - M; i++) {
			while (set.contains(number)) number++;
			numbers[i] = number++;
		}
		
		solve();
	}

	static void solve() {
		bt(0, 0, 1);
		System.out.println(ans);
	}
	
	static void bt(int start, int depth, long res) {
        if (depth == 3) {
            ans = Math.min(ans, (int)Math.abs(N - res));
            return;
        }
        for (int i = start; i < numbers.length; i++) {          // 오름차순 순회로 변경 // Changed
            long next = res * numbers[i];
            if (next - N > ans) break;                       // 단조성 기반 가지치기 // Changed
            bt(i, depth + 1, next);
        }
    }
}