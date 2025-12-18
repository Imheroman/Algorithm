import java.io.*;
import java.util.*;

// 잼민이 코드임
public class Main {
    static int N, M;
    static int[][] items;
    static int[][] memo;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        items = new int[N][M];
        memo = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                items[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // DP 테이블 초기화 (아직 계산 안 함 표시)
        for(int[] row : memo) Arrays.fill(row, -1);

        // 첫 번째 줄(0번 행)부터 시작해서 최소 비용 찾기
        int answer = INF;
        
        // 0번 행을 시작으로 재귀를 돌리지만, 
        // 사실 내부적으로 solve(0) 한번만 호출하면 그 안에서 다 해결하도록 설계할 수도 있습니다.
        // 여기서는 이해를 돕기 위해 각 시작점 별로 호출하되, 메모이제이션을 활용합니다.
        
        // 핵심: 맨 윗줄의 각 칸을 시작점으로 잡았을 때의 최솟값을 구함
        for (int j = 0; j < M; j++) {
            answer = Math.min(answer, solve(0, j));
        }
        System.out.println(answer);
    }

    // depth: 현재 행(row), col: 현재 행에서 선택한 열
    static int solve(int depth, int col) {
        // 기저 사례: 마지막 행이면 해당 아이템 비용 반환
        if (depth == N - 1) return items[depth][col];

        // 이미 계산한 적 있다면 메모해둔 값 리턴 (메모이제이션)
        if (memo[depth][col] != -1) return memo[depth][col];

        // -------------------------------------------------------
        // 여기가 최적화의 핵심입니다!
        // 다음 행(depth + 1)의 모든 칸을 미리 계산해보고
        // 그 중 1등(min1)과 2등(min2)을 찾습니다.
        // -------------------------------------------------------
        
        // 하지만! 이렇게 매번 함수 안에서 루프를 돌면 느립니다.
        // "재귀를 유지하면서 최적화"하려면, memo 배열을 적극 활용해야 합니다.
        // 여기서는 논리의 흐름을 위해 직관적으로 작성하되,
        // 이미 계산된(memo에 있는) 값을 가져오므로 실제로는 빠릅니다.

        int minVal = INF;
        
        // 다음 행의 1등, 2등 값을 찾기 위해 한번 훑어봅니다.
        // (이 부분도 더 최적화 가능하지만, 메모이제이션 덕분에 충분히 빠릅니다)
        for (int nextCol = 0; nextCol < M; nextCol++) {
            if (col == nextCol) continue; // 같은 열은 선택 불가
            minVal = Math.min(minVal, solve(depth + 1, nextCol));
        }

        return memo[depth][col] = items[depth][col] + minVal;
    }
}