import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int N, M, ans;
	static char[] numbers;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		System.out.println(ans);
	}

	public static void init() throws IOException {  // 입력 받기
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		ans = Math.abs(N - 100);
		
		numbers = new char[M];
		
		if (M == 0) return;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) numbers[i] = st.nextToken().charAt(0);
	}
	
	public static void solve() {
		for (int current = 0; current < (N + 1) * 10; current++) {
			boolean flag = true;
			String now = String.valueOf(current);
			
			for (int i = 0; i < now.length() && flag; i++) flag = isAvailableNumber(now.charAt(i));
			
			if (!flag) continue;
			
			int res = Math.abs(N - current) + now.length();
			ans = ans < res ? ans : res;
		}
	}
	
	static boolean isAvailableNumber(char current) {
		for (char n : numbers) if (current == n) return false;
		
		return true;
	}
}