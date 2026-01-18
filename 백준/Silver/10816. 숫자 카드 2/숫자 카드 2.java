import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        
		int N = Integer.parseInt(br.readLine());
		int[] target = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) target[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(target);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int number = Integer.parseInt(st.nextToken());
			int lower = binarySearch(target, number),
					upper = binarySearch(target, number + 1);
			
			if (lower <= 0 && upper <= 0) sb.append(0);
			else sb.append(upper - lower);
			sb.append(" ");
		}
		
		System.out.println(sb);
	}
	
	static int binarySearch(int[] target, int number) {
		int left = 0, right = target.length;
		
		while (left < right) {
			int mid = (left + right) / 2;
			
			if (target[mid] >= number) right = mid;
			else left = mid + 1;
		}
		
		return left;
	}
}