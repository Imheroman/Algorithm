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
		for (int current = 0; current < 1_000_000; current++) {
			boolean flag = true;  // 만들 수 있는 수자인지 확인
			String now = String.valueOf(current);
			
			for (int i = 0; i < now.length() && flag; i++) flag = isAvailableNumber(now.charAt(i));
			
			if (!flag) continue;  // 만들 수 없는 숫자라면 pass
			
            // 만들 수 있는 숫자면 ++ 또는 --로 크기 확인
			int res = Math.abs(N - current) + now.length();
			ans = ans < res ? ans : res;
		}
	}
	
	static boolean isAvailableNumber(char current) {
		for (char n : numbers) if (current == n) return false;
		
		return true;
	}
}