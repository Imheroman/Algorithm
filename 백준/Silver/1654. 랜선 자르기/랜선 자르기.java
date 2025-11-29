import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br; 

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	private static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken()),
				N = Integer.parseInt(st.nextToken());
		
		int[] numbers = new int[K];
		long max = 0;
		for (int k = 0; k < K; k++) {
			numbers[k] = Integer.parseInt(br.readLine());
			max = Math.max(max, numbers[k]);
		}
		
		solve(numbers, K, N, ++max);  // upper bound를 위해 +1
	}

	private static void solve(int[] numbers, int K, int N, long max) {
		long min = 0;
		
		while (min < max) {
			long mid = (max + min) / 2;
			long cnt = count(numbers, mid);
			
			if (cnt >= N) min = mid + 1;  // cnt가 N보다 크면(divider의 값을 더 키울 수 있다면) 
			else max = mid;
		}
		
		System.out.println(min - 1);  // upper bound까지 check하기 때문에, -1
	}
	
	static long count(int[] numbers, long divider) {
		long cnt = 0;
		
		for (int number : numbers) cnt += number / divider;
		
		return cnt;
	}
}