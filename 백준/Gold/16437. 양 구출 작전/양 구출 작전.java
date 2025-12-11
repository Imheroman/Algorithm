import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br; 
	static long[] animals;
	static List<Integer>[] graphs;
	

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	private static void init() throws IOException {		
		int N = Integer.parseInt(br.readLine());
		animals = new long[N + 2];
		animals[1] = 0;
		
		graphs = new List[N + 1];
		for (int i = 0; i < N + 1; i++) graphs[i] = new ArrayList<>();
		
		for (int i = 0; i < N - 1 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String animal = st.nextToken();
			int size = Integer.parseInt(st.nextToken()),
					parent = Integer.parseInt(st.nextToken()),
					index = i + 2;
			
			if (animal.equals("W")) size *= -1;
			animals[index] = size;
			graphs[parent].add(index);
		}
		
		System.out.println(dfs(1));
	}
	
	static long dfs(int node) {
		long sum = animals[node];
		for (int next : graphs[node]) sum += dfs(next);
		
		return sum >= 0 ? sum : 0;
	}
}