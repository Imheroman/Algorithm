import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = getInt();
		int[] numbers = new int[n];
		
		st = input();
		for (int i = 0; i < n; i++) {
			numbers[i] = getInt(st);
		}
		Arrays.sort(numbers);
		
		int[] answer = new int[2];
		int l = 0, r = n - 1, result = Integer.MAX_VALUE;
		while (l < r) {
			int current = numbers[l] + numbers[r];
			
			if (Math.abs(current) < result) {
				answer[0] = numbers[l];
				answer[1] = numbers[r];
				result = Math.abs(current);
			}
			
			if (current > 0) {
				r--;
			} else {
				l++;
			}
		}
		
		System.out.println(answer[0] + " " + answer[1]);
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