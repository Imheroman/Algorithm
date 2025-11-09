import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int R, C, M;
	static final int[][] DIRECTIONS = {{}, {-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static Set<Shark> sharks;
	static Shark[][] graphs;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	static void init() throws IOException {
		sharks = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graphs = new Shark[R][C];
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1,
					c = Integer.parseInt(st.nextToken()) - 1,
					s = Integer.parseInt(st.nextToken()),
					d = Integer.parseInt(st.nextToken()),
					z = Integer.parseInt(st.nextToken());
			
			Shark shark = new Shark(r, c, s, d, z);
			graphs[r][c] = shark;
			sharks.add(shark);
		}

      solve();
	}
	
	static void solve() {
		int ans = 0;
		
		for (int j = 0; j < C; j++) {
			for (int i = 0; i < R; i++) {
				if (graphs[i][j] != null && graphs[i][j].isAlive) {
					sharks.remove(graphs[i][j]);
					ans += graphs[i][j].z;
					graphs[i][j] = null;
					break;
				}
			}
			
			for (Shark current : sharks) {
				if (!current.isAlive) continue;
				if (graphs[current.r][current.c] == current) graphs[current.r][current.c] = null;
				
				current.move();
				
				Shark origin = graphs[current.r][current.c];
              
				if (origin == null || origin.moveCnt != current.moveCnt) graphs[current.r][current.c] = current;
				else {
					if (origin.z < current.z) {
						origin.die();
						graphs[current.r][current.c] = current; 
					} else current.die();
				} 

            }
		}
		
		System.out.println(ans);
	}
	
	static class Shark {
		int r, c, s, d, z, moveCnt;
		boolean isAlive;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
			
			this.isAlive = true;
			moveCnt = 0;
		}

		public void move() {
			int speed = this.s; // 실제 이동할 속력
			
			// 1. 상하 이동일 경우 (d = 1 or 2)
			if (d == 1 || d == 2) {
				int cycle = (R - 1) * 2; // 왕복 1번의 이동 횟수 (예: R=6이면 0->5->0, 총 10칸)
				
				// R=1인 경우 cycle이 0이 될 수 있으므로 방어 코드 (문제 조건은 R,C >= 2)
				if (cycle > 0) speed %= cycle; // 1000번 이동 -> (1000 % 10) = 0번 이동과 같음
			} 
			// 2. 좌우 이동일 경우 (d = 3 or 4)
			else {
				int cycle = (C - 1) * 2; // 왕복 1번의 이동 횟수
				if (cycle > 0) speed %= cycle;
			}

			// 3. O(1)로 최적화된 speed 만큼만 1칸씩 이동
			for (int i = 0; i < speed; i++) {
				int nr = this.r + DIRECTIONS[d][0];
				int nc = this.c + DIRECTIONS[d][1];
				
				// 범위를 벗어나면 방향 전환
				if (!isValidRange(nr, nc)) {
					d = d % 2 == 0 ? d - 1 : d + 1; // (1<->2, 3<->4) 방향 전환
					// 방향 바꾼 후의 좌표로 갱신
					nr = this.r + DIRECTIONS[d][0];
					nc = this.c + DIRECTIONS[d][1];
				}
				
				// 위치 갱신
				this.r = nr;
				this.c = nc;
			}
			
			++this.moveCnt;
		}
		
		public void die() {
			this.isAlive = false;
		}
		
		private boolean isValidRange(int x, int y) {
			return 0 <= x && x < R && 0 <= y && y < C;
		}
	}
}