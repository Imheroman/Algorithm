import java.io.*;
import java.util.*;

/*
로직을 모르겠어서 블로그 보고 풀었음
https://velog.io/@030831/%EB%B0%B1%EC%A4%80-23829-%EC%9D%B8%EB%AC%BC%EC%98%88%EC%88%A0%ED%83%90%EC%82%AC%EC%A3%BC%EA%B0%84-Python

나보다 작은 쪽과 나보다 큰 쪽을 구분해서 문제 해결
*/
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, Q;
	static int[] trees;
	static long[] prefixSum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		trees = new int[N];
		prefixSum = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) trees[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(trees);
        
		for (int i = 0; i < N; i++) {
			if (i == 0) prefixSum[i] = trees[i];
			if (i > 0) prefixSum[i] += prefixSum[i - 1] + trees[i];  
		}
		
		// 1. 이분 탐색으로 현재 위치보다 크거나 같은 지점 찾기 
		// 2. 나보다 작은 위치에서 abs(pos * idx - prefixSum[idx]) + abs(pos * (N - idx) - (prefixSum[N - 1] - prefixSum[N - idx))
		for (int t = 0; t < Q; t++) {
			long pos = Long.parseLong(br.readLine());
            long result = solve(pos);
              
            sb.append(Math.abs(result)).append("\n");
        }
                                                    
		System.out.println(sb);
	}
    
    static long solve(long pos) {
        if (trees[0] < pos && pos < trees[N - 1]) {  // 나무들 사이에 있는 경우
            int idx = Arrays.binarySearch(trees, (int) pos);
            if (idx < 0) idx = (idx + 1) * -1;  // 나보다 큰 위치 바로 전  
                
            long left = pos * (idx) - prefixSum[idx - 1],
            right = (prefixSum[N - 1] - prefixSum[idx - 1]) - pos * (N - idx);
            
            return left + right;
        } else return N * pos - prefixSum[N - 1];  // pos가 나무들보다 가장 크거나, 나무들보다 가장 작은 경우
    }
}