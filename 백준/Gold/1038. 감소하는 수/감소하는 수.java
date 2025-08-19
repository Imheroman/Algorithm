import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static List<Long> answer = new ArrayList<>();
	static int N;
	
	public static void main(String[] args) throws IOException {
		init();
		solve();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
	}
	
	static void solve() {
		if (N <= 10) {
			System.out.println(N);
			return;
		} else if (N >= 1023) {
			System.out.println(-1);
			return;
		}
		
		for (int limit = 1; limit < 11; limit++) {
			for (long number = 0; number < 10; number++) 
				comb(number, 1, limit);
		}
		
		
		Collections.sort(answer);
		System.out.println(answer.get(N));
	}
	
	static void comb(long current, int size, int limit) {
		if (size >= limit) {
			answer.add(current);
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if (current < 10 && current < i)
				comb((long) (current + i * Math.pow(10.0, size)), size + 1, limit);				
			else if (current >= 10) {
				long num = current;
				while (num >= 10) num /= 10;
				
				if (num < i) comb((long) (current + i * Math.pow(10.0, size)), size + 1, limit); 
			}
		}
	}
}