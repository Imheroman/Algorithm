import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = getInt();
		ArrayDeque<Integer> queue = new ArrayDeque();
		
		for (int number = 1; number <= N;) {
			queue.add(number++);
		}
		
		StringBuilder answer = new StringBuilder();
		while (queue.size() > 1) {
			answer.append(queue.pollFirst()).append(" ");
			queue.add(queue.pollFirst());
		}
		
		System.out.println(answer.append(queue.poll()));
	}
	
	public static StringTokenizer input() throws IOException {
		return new StringTokenizer(br.readLine());
	}

	public static int getInt(StringTokenizer s) {
		return Integer.parseInt(s.nextToken());
	}

	public static int getInt() throws IOException {
		return Integer.parseInt(br.readLine());
	}
}