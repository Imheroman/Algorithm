import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br; 
	
	static int N, K;
    static long min, max, answer;
	static int[] characters;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	private static void init() throws IOException {
		min = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		characters = new int[N];
		for (int n = 0; n < N; n++) {
			characters[n] = Integer.parseInt(br.readLine());
			
			min = Math.min(min, characters[n]);
			max = Math.max(max, characters[n]);
		}
		
        max += K;
		Arrays.sort(characters);
        
        if (N == 1) answer = characters[0] + K;
        else solve();
        
		System.out.println(answer);
	}

	/**
	 * 1. 최솟값을 찾는다.
	 * 2. 최소 다음 값을 찾는다.
	 * 3. 최솟값을 최소 다음 보다 1크게 증가시킨다 ?
	 * 
	 * 위 방식은 예제 입력부터 통과되지 않음
	 * 15 15 20 이 있고, K가 5일 때, 17 17 20이 아니라, 15 20 20이 나옴
	 * 
	 * 그냥 블로그 참고 -> https://jinho-study.tistory.com/720
	 */
	static void solve() {
		while (min <= max) {
			long mid = (min + max) >> 1;
			long sum = 0;
		
			for (int c : characters) {
				if (mid > c) sum += mid - c;
			}
			
			if (sum > K) {  // 변경할 수 없음. mid값 줄이기 
				max = mid - 1;
			} else {   // 변경할 수 있음. answer값 초기화하고, min 크기 늘리
				answer = Math.max(answer, mid);
				min = mid + 1;
			}
		}
	}
}