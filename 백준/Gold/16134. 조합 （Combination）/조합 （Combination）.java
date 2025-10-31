import java.io.*;
import java.util.*;

// 페르마의 소정리로 풀던 문제 쌀먹 ..
public class Main {
	static BufferedReader br;
	static int MOD = 1_000_000_007;
	static int N, M;
	static long ans;
	static long[] factorials;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		System.out.println(ans);
	}

	static void init() throws IOException {
		ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		factorials = new long[N + 1];
		fact(N + 1);
	}
	
	static void solve() {
		long n = factorials[N];
		
		long m = (factorials[M] * factorials[N - M]) % MOD;
		long denominator = pow(m, MOD - 2);  // (M! * (N - M)!)이 분모가 되어야 하니까. 역수를 치해주어야 함 -> 역수를 만들기 위해서 페르마의 소정리(p -2)를 이용해서 역수를 취함
		
		ans = n * denominator  % MOD;  // denominator는 m에 역수가 취해졌으니까 곱하기로 되는 거임
	}
	
	static void fact(int n) {
		long res = 1;
		
		factorials[0] = 1;
		for (int number = 1; number < n; number++) factorials[number] = res = (res * number)  % MOD;
	}
	
	static long pow(long n, int exponent) {
		if (exponent == 0) return 1;
		else if (exponent == 1) return n % MOD;
		
		long res = pow(n, exponent / 2);
		long result = (res * res) % MOD;
		return exponent % 2 == 0 ? result : (result * n) % MOD;
	}
}