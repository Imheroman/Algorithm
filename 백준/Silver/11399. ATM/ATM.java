import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	static void init() throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(numbers);
		solve(numbers);
	}
	
	static void solve(int[] numbers) {
		int ans = 0, sum = 0;
		
		for (int number : numbers) {
			sum += number;
			ans += sum;
		}
		
		System.out.println(ans);
	}
}