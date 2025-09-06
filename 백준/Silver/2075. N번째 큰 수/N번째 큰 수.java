import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static Queue<Integer> queue;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
	}

	public static void init() throws IOException {  // 입력 받기
		queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) queue.offer(Integer.parseInt(st.nextToken()));
		}
	}
	
	public static void solve() {
		while (--N > 0) queue.poll();
		System.out.println(queue.poll());
	}
}