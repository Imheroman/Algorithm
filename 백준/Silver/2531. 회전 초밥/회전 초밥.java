import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, D, K, C;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
				
		int[] graphs = new int[N];
		for (int i = 0; i < N; i++) graphs[i] = Integer.parseInt(br.readLine());
		
		solve(graphs);
	}
 
	static void solve(int[] graphs) {
		int ans = 0;
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = i; j < i + K; j++) set.add(graphs[j % N]);

			int size = set.contains(C) ? set.size() : set.size() + 1;
			ans = ans > size ? ans : size;
			
			set.clear();
		}
		
		System.out.println(ans);
	}
}