import java.io.*;
import java.util.*;

// gemini 코드 손민수 ..
public class Main {
	static BufferedReader br;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}
	
	static void init() throws IOException {		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] numbers = new int[100];
		for (int i = 0; i < N; i++) {
			int idx = Integer.parseInt(st.nextToken());
			++numbers[idx];
		}
		
		solve(N, K, numbers);
	}
	
	static void solve(int N, int K, int[] numbers) {
		for (int current = 1; current <= N; current++) {  // 1 ~ N까지 탐색
			if (numbers[current]-- > 0) {  // 배열에 값이 있으면 ? (일단 -1)
				int next = current + K;  // 현재 값에서 이동할 수 있는 값
				if (current + K < numbers.length) numbers[next] += numbers[current];  // 다음 값으로 남은 값들을 이동
			} else {  // 배열에 존재하는 값이 없으면, 0
				System.out.println(0);
				return;
			}
		}
		
		System.out.println(1);
	}
}