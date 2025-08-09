import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = getInt(st), S = getInt(st);
        
		st = new StringTokenizer(br.readLine());
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = getInt(st);
		}

		int answer = 0;
		for (int selected = 1; selected < 1 << N; selected++) {
			int sum = 0;
			for (int index = 0; index < N; index++) {
				if ((selected & 1 << index) != 0) {
					sum += numbers[index];
				}
			}
			
			if (sum == S) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	public static int getInt(StringTokenizer s) {
		return Integer.parseInt(s.nextToken());
	}
}