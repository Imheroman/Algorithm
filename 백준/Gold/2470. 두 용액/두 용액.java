import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br; 
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}
	
	private static void init() throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numbers.length; i++) numbers[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(numbers);
		solve(N, numbers);
	}

	static void solve(int N, int[] numbers) {
		int minId = 0, maxId = N - 1;
		int head = 0, tail = N - 1;
		int result = Integer.MAX_VALUE;
		
		while (head < tail && result != 0) {
			int sum = numbers[head] + numbers[tail];
            
			if (result > Math.abs(sum)) {  // result 갱신
				result = Math.abs(sum);
				minId = head;
				maxId = tail;
			}
			
            // 포인터 이동
			if (sum > 0) --tail;
			else ++head;
		} 
		
		System.out.println(numbers[minId] + " " + numbers[maxId]);
	}
}