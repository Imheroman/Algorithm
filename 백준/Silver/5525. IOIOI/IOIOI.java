import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br; 

    // 그냥 지피티 코드 ..
    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}
	
	private static void init() throws IOException {
		int N = Integer.parseInt(br.readLine()),
				M = Integer.parseInt(br.readLine());
		
		solve(N, M, br.readLine().toCharArray());
	}
  
	static void solve(int N, int M, char[] letters) {
		int answer = 0, cnt = 0;
		
		for (int current = 0; current < M - 2; current++) {
			if (letters[current] == 'I' && letters[current + 1] == 'O' && letters[current + 2] == 'I') {
				if (++cnt >= N) ++answer;  // 계속 패턴이 반복되면, +1씩 증가
				
				++current;  // 2개 update 
			} else cnt = 0;  // 패턴이 깨지면, 0부터 다시 시작
		}
		
		System.out.println(answer);
	}
}