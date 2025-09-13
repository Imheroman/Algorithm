// 25.09.13 B형 특강 문제

import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br;
	static Queue<Integer> smaller, bigger;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			smaller = new PriorityQueue<>((a, b) -> b - a);
			bigger = new PriorityQueue<>();
			long ans = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			
			bigger.add(A);
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				bigger.offer(a);
				smaller.offer(b);
				
				if (bigger.peek() < smaller.peek()) {
					int temp = smaller.poll();
					smaller.offer(bigger.poll());
					bigger.offer(temp);
				}
				
				ans = (ans + bigger.peek()) % 20171109;
 			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}