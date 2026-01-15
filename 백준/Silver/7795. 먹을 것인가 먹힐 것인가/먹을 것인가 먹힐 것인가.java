import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()),
					M = Integer.parseInt(st.nextToken());
			
			int[] numbers = parseInts(new StringTokenizer(br.readLine()), N);
			Arrays.sort(numbers);

			int answer = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int target = Integer.parseInt(st.nextToken());
				answer += numbers.length - binarySearch(numbers, target);
			}
			
			sb.append(answer).append("\n");
        }
		
		System.out.println(sb);
	}
	
	static int binarySearch(int[] target, int number) {
		int start = 0, end = target.length;
		
		while (start < end) {
			int mid = (start + end) / 2;
			
			if (target[mid] <= number) start = mid + 1;
			else end = mid;
		}
		
		return end;
	}
	
	public static int[] parseInts(StringTokenizer st, int N) {
		int[] numbers = new int[N];
		
		for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(numbers);
		return numbers;
	}
}