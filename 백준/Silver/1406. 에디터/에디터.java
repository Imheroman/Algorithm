import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int COMMAND = 0, LETTER = 2;
	static Deque<Character> left = new ArrayDeque<>(), right = new ArrayDeque<>();
	static char[][] commands;

	public static void main(String[] args) throws IOException {
		init();
		solve();
	}
	
	public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] letters = br.readLine().toCharArray();
		for (char letter : letters) left.add(letter);
		
		int n = Integer.parseInt(br.readLine());
		commands = new char[n][3];
		
		for (int i = 0;i < n; i++) commands[i] = br.readLine().toCharArray();
	}
	
	public static void solve() {
		for (char[] command : commands) {
			switch (command[COMMAND]) {
			case 'L':
				if (!left.isEmpty()) right.offerFirst(left.pollLast());
				break;
			case 'D':
				if (!right.isEmpty()) left.offer(right.poll());
				break;
			case 'B':
				if (!left.isEmpty()) left.pollLast();
				break;
			case 'P':
				left.offer(command[LETTER]);
				break;
			}
		}
		
		left.forEach(sb::append);
		right.forEach(sb::append);
		System.out.println(sb);
	}
}