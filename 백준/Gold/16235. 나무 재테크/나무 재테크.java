import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] DIRECTIONS = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
	static int N, M, K;
	static int[][] A, resourceBoard;
	static boolean[][][] isDead;
	static Map<Integer, ArrayDeque<Tree>> trees;
	static Deque<Tree> deadTrees;

	public static void main(String[] args) throws IOException {
		init();
		solve();
	}

	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		deadTrees = new ArrayDeque<Tree>();
		trees = new HashMap<>();
		for (int i = 0; i < N * N + N + 1; i++) trees.put(i, new ArrayDeque<>());
		
		A = new int[N + 1][N + 1];
		resourceBoard = new int[N + 1][N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				resourceBoard[i][j] =  5;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), age = Integer.parseInt(st.nextToken());
			trees.get(x * N + y).add(new Tree(x, y, age));
		}
	}

	static void solve() {
		for (int years = 0; years < K; years++) {
			spring();
			summer();
			fall();
			winter();
		}
		
		int answer = 0;
		for (ArrayDeque<Tree> deque : trees.values())
			answer += deque.size();
		System.out.println(answer);
	}
	
	static void spring() {
		for (int key = 0; key < N * N + N + 1; key++) {
			Deque<Tree> repo = trees.get(key);
			
			if (repo.isEmpty()) continue;
			int size = repo.size();
			for (int i = 0; i < size; i++) {
				Tree t = repo.poll();
				if (t.age > resourceBoard[t.x - 1][t.y - 1]) deadTrees.add(t);
				else {
					resourceBoard[t.x - 1][t.y - 1] -= t.age; 
					++t.age;
					repo.add(t);
				}
			}
		}
	}
	
	static void summer() {
		while (!deadTrees.isEmpty()) {
			Tree t = deadTrees.poll();
			resourceBoard[t.x - 1][t.y - 1] += t.age / 2; 
		}
	}
	
	static void fall() {
		for (int key = 0; key < N * N + N + 1; key++) {
			for (Tree t : trees.get(key)) {
				if (t.age % 5 == 0) {
					for (int[] d : DIRECTIONS) {
						int nx = t.x + d[0], ny = t.y + d[1];
						int pos = N * nx + ny;
						
						if (0 < nx && nx < N + 1 && 0 < ny && ny < N + 1) trees.get(pos).addFirst(new Tree(nx, ny));
					}
				}
			}
		}
	}
	
	static void winter() {
		for (int i = 0; i < N + 1; i++)
			for (int j = 0; j < N + 1; j++) 
				resourceBoard[i][j] += A[i][j];
	}
	
	static class Tree {
		int x, y, age;
		static final int DEFAULT_AGE = 1;
		
		public Tree(int x, int y) {
			this(x, y, DEFAULT_AGE);
		}
		
		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}
	}
}