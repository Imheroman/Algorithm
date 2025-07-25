import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = input();
		int N = getInt(st), M = getInt(st);
		
		st = input();
		int[] numbers = new int[N];
		numbers[0] = getInt(st);
		
		for (int i = 1; i < N; i++) {
			numbers[i] = getInt(st) + numbers[i - 1];
		}
		
		StringBuilder answer = new StringBuilder(); 
		for (int t = 0; t < M; t++) {
			st = input();
			int start = getInt(st) - 1, end = getInt(st) - 1;
			
			if (start == 0) {
				answer.append(numbers[end]);
			} else {
				answer.append(numbers[end] - numbers[start - 1]);
			}
			answer.append("\n");
		}
		
		System.out.println(answer);
	}
	
	public static StringTokenizer input() throws IOException {
		return new StringTokenizer(br.readLine());
	}
	
	public static int getInt(StringTokenizer s) {
		return Integer.parseInt(s.nextToken());
	}
}