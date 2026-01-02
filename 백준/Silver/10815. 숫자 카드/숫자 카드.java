import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
		int N = Integer.parseInt(br.readLine());
		int[] repository = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) repository[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(repository);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
          int result = find(repository, N, Integer.parseInt(st.nextToken()));
          sb.append(result).append(" ");
        }
			
		System.out.println(sb);
	}
	
	static int find(int[] repository, int N, int key) {
		int start = 0, end = N - 1;
		
		while (start <= end) {
			int mid = (start + end + 1) / 2;
			
			if (repository[mid] == key) {
				return 1;
			} else if (repository[mid] > key) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		return 0;
	}
}