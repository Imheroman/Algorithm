import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = getInt();
		st = input();
		int[] numbers = new int[n];
		
		for (int i = 0; i < n; i++) {
			numbers[i] = getInt(st);
		}
		Arrays.sort(numbers);

		
		int target = getInt();
		int start = 0, end = n - 1, sum = 0, answer = 0;
		
		while (start < end) {
			sum = numbers[start] + numbers[end];
			
			if (sum == target) {
				start++;
				end--;
				answer++;
			} else if (sum > target) {
				end--;
			} else {
				start++;
			}
		}
		
		System.out.println(answer);
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