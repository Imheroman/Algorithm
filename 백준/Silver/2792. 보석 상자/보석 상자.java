import java.io.*;
import java.util.*;

// 내 코드 아님 ..
// https://www.acmicpc.net/problem/1120
public class Main {
	static int N, M;
	static int[] beads;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		beads = new int[M];
		
		int max = 0;
		for (int i = 0; i < M; i++) {
			beads[i] = Integer.parseInt(br.readLine());
			max = max > beads[i] ? max : beads[i];
		}
		
		solve(max);
	}
	
	static void solve(int end) {
		int start = 1;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			
			// sum이 더 크면(줄 수 있는 사람이 더 많으면) ? 사이즈를 더 키워도 됨 !
			if (sum(mid) > N) start = mid + 1;
			// N이 더 작으면 (줄 수 있는 사람이 더 적으면) ? 사이즈를 더 줄여야됨
			else end = mid - 1;
		} 
		
		System.out.println(start);
	}
	
	static int sum(int key) {
		int people = 0;
		
		for (int i = 0; i < M; i++) {
			int p = beads[i] / key, // 나눠줄 수 있는 사람의 수
					remain = beads[i] % key == 0 ? 0 : 1;  // 나머지를 넘겨줄 사람 추가
			
			people += p + remain;
		}
		
		return people;
	}
}