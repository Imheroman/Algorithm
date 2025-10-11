import java.io.*;
import java.util.*;

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
	
	static void bt(int start, int depth, int res) {
		if (depth == MAX_DEPTH) {
			int result = Math.abs(N - res);
			ans = ans < result ? ans : result; 
			return;
		}
			
		for (int i = start; i < numbers.length; i++)
			bt(i, depth + 1, res * numbers[i]);
	}
}