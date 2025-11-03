import java.io.*;
import java.util.*;

// 보고 쓴 블로그 : https://gemini.google.com/app/7e4a1f0b079ffbec
public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static final int GRAPH_INIT_SIZE = 3, GRAPH_MAX_SIZE = 101, NUMBER = 0, COUNT = 1;
	static int r, c, k, rSize, cSize;
	static int[][] graphs;
		
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	static void init() throws IOException {
		rSize = GRAPH_INIT_SIZE;
		cSize = GRAPH_INIT_SIZE;
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		k = Integer.parseInt(st.nextToken());
		
		graphs = new int[GRAPH_MAX_SIZE][GRAPH_MAX_SIZE];
		for (int i = 0; i < GRAPH_INIT_SIZE; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < GRAPH_INIT_SIZE; j++) graphs[i][j] = Integer.parseInt(st.nextToken());
		}
		
		solve();
	}
  
	static void solve() {
		int time = -1;
		while (++time < GRAPH_MAX_SIZE && graphs[r][c] != k) {
			if (rSize >= cSize) { 
				for (int i = 0; i < rSize; i++) rsort(i);
			}
			else {
				for (int i = 0; i < cSize; i++) csort(i);
			}
		}
		
		System.out.println(graphs[r][c] == k ? time : -1);
	}

	static void rsort(int row) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int col = 0; col < cSize; col++) {
			int key = graphs[row][col];
			if (key == 0) continue;
			map.compute(key, (num, cnt) -> cnt == null ? 1 : cnt + 1);
		}
		
		Queue<int[]> queue = new PriorityQueue<>((pre, post) -> pre[COUNT] == post[COUNT] ? 
				Integer.compare(pre[NUMBER], post[NUMBER]) : Integer.compare(pre[COUNT], post[COUNT]));
		
		map.forEach((key, val) -> queue.offer(new int[] {key, val}));
		
		int index = 0;
		while (!queue.isEmpty()) {
			int[] data = queue.poll();
			graphs[row][index] = data[NUMBER];
			graphs[row][index + 1] = data[COUNT];
			
			index += 2;
		}
		
		cSize = Math.max(cSize, index);
		
		while (index < GRAPH_MAX_SIZE) graphs[row][index++] = 0;
	}
	
	static void csort(int col) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int row = 0; row < rSize; row++) {
			if (graphs[row][col] == 0) continue;
			map.compute(graphs[row][col], (num, cnt) -> cnt == null ? 1 : cnt + 1);
		}
		
		Queue<int[]> queue = new PriorityQueue<>((pre, post) -> pre[COUNT] == post[COUNT] ? 
				Integer.compare(pre[NUMBER], post[NUMBER]) : Integer.compare(pre[COUNT], post[COUNT]));
		
		map.forEach((key, val) -> queue.offer(new int[] {key, val}));		
		
		int index = 0;
		while (!queue.isEmpty()) {
			int[] data = queue.poll();
			graphs[index][col] = data[NUMBER];
			graphs[index + 1][col] = data[COUNT];
			
			index += 2;
		}
		
		rSize = Math.max(rSize, index);
		
		while (index < GRAPH_MAX_SIZE) graphs[index++][col] = 0;
	}
}