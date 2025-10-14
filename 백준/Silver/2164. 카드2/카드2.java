import java.io.*;
import java.util.*;

// 참고 블로그: https://st-lab.tistory.com/188
public class Main {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		
		int[] queue = new int[2 * N];	  
		for(int i = 0; i < N; i++) queue[i] = i +1;
		int head = 0;  // queue의 head
		int tail = N - 1;  // queue의 tail
		
		solve(queue, N, head, tail);
	}

	static void solve(int[] queue, int N, int head, int tail) {
		while (N-- > 1) {  // 데이터가 1개 남을 때 까
//			System.out.println("N: " + N + ", head: " + head + ", tail: " + tail + " -> queue: " + Arrays.toString(queue));
			queue[++tail] = queue[++head];  // tail의 다음에 처음 버리고 값 넣 
			++head;  // 값 버리기
		}
		
		System.out.println(queue[head]);
	}
}