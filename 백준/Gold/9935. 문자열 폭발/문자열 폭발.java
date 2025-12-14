import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br; 

	static Deque<Character> deque = new ArrayDeque<>();
	static char[] line, pattern;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}


	private static void init() throws IOException {
		line = br.readLine().toCharArray();
		char[] p = br.readLine().toCharArray();
		
		int length = p.length;
		pattern = new char[length];
		for (int i = 0; i < length; i++) pattern[i] = p[length - i - 1];
		
		solve();
	}
	
	static void solve() {
		for (int i = 0; i < line.length; i++) {
			
			deque.offer(line[i]);
			if (deque.size() < pattern.length) continue;
			
			int match = isMatch();
			
			if (match == pattern.length) {
				for (int j = 0; j < pattern.length; j++) deque.poll();
			} else {
				for (int j = 0; j < match; j++) deque.offer(deque.poll());
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (!deque.isEmpty()) sb.append(deque.poll());
		
		System.out.println(sb.length() == 0 ? "FRULA" : sb);
	}
	
	static int isMatch() {
		int cnt = 0;
		for (int i = 0; i < pattern.length; i++) {
			if (deque.peekLast() != pattern[i]) break;
			
			deque.offerFirst(deque.pollLast());
			++cnt;
		}
		
		return cnt;
	}
}