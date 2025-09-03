import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int MAX_VAL = 99999999;
	static int N, M, K;
	static int[] startPos, endPos;
	static int[][] graphs, DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		System.out.println(graphs[endPos[0]][endPos[1]] == MAX_VAL ? -1 : graphs[endPos[0]][endPos[1]]);
	}

	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		graphs = new int[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++)
				graphs[i][j] = line.charAt(j) == '.' ? MAX_VAL : -1;
		}

		st = new StringTokenizer(br.readLine());
		startPos = new int[] { Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1 };
		endPos = new int[] { Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1 };
	}

	// 기존 코드에서 이 메소드만 교체하시면 됩니다.
    static void solve() {
        // 시작점과 끝점이 같은 경우에 대한 처리는 main에서 하는 것이 더 깔끔할 수 있습니다.
        // 여기서는 기존 코드를 유지합니다.
        if (startPos[0] == endPos[0] && startPos[1] == endPos[1]) {
            // 시작과 끝이 같으면 0초가 걸리지만, 기존 코드에는 이 부분 출력이 없어 추가합니다.
            // 만약 이 코드가 없어서 틀렸다면, main의 출력 부분이 0을 처리하지 못했을 수 있습니다.
            // 하지만 BFS 로직 오류가 더 크므로 아래 로직 수정이 핵심입니다.
            System.out.println(0);
            return;
        }
        // 끝점이 벽인 경우는 BFS 결과 MAX_VAL이 남아 -1로 처리되므로, 여기서 굳이 return할 필요는 없습니다.
    
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { startPos[0], startPos[1] });
        graphs[startPos[0]][startPos[1]] = 0;
    
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curTime = graphs[cur[0]][cur[1]]; // 가독성을 위해 현재 시간을 변수로 저장
    
            for (int[] d : DIRECTIONS) {
                int nx = cur[0];
                int ny = cur[1];
                for (int k = 0; k < K; k++) {
                    nx += d[0];
                    ny += d[1];
    
                    // 1. 맵 밖으로 나가거나 벽을 만나면, 이 방향으로는 더 이상 진행 불가
                    if (!(0 <= nx && nx < N && 0 <= ny && ny < M && graphs[nx][ny] != -1)) {
                        break;
                    }
    
                    // 2. 이미 더 빠른 경로로 방문한 지점이라면, 이 방향 탐색은 무의미하므로 중단
                    if (graphs[nx][ny] < curTime + 1) {
                        break;
                    }
    
                    // 3. 아직 방문하지 않은 새로운 지점인 경우에만 시간 갱신 및 큐에 추가
                    // (기존 코드와 달리, 'curTime + 1'과 같은 경우는 통과시켜서 더 진행할 수 있도록 함)
                    if (graphs[nx][ny] == MAX_VAL) {
                        graphs[nx][ny] = curTime + 1;
                        queue.offer(new int[] { nx, ny });
                    }
                }
            }
        }
    }
}
