import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br; 

	static long max;
	static int N, K;
	static int[] drinks;
	

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	private static void init() throws IOException {
		max = Integer.MIN_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		drinks = new int[N];
		for (int n = 0; n < N; n++) {
			drinks[n] = Integer.parseInt(br.readLine());
			max = Math.max(max, drinks[n]);
		}
		
		solve();
	}
	
	/**
	 * 몫의 합이 K보다 큰 가장 큰 수 찾기
	 */
	static void solve() {
		long answer = 0, min = 1;
		
		while (min <= max) {
			long mid = (min + max) >> 1;
			long result = devideSum(mid);
			
			if (result >= K) {
				min = mid + 1;
				answer = Math.max(answer, mid);
			} else {
				max = mid - 1;
			}
		}
		
		System.out.println(answer);
	}
	
	static long devideSum(long devider) {
		long sum = 0;
	
		for (int d : drinks) sum += d / devider;
		
		return sum;
	}
}