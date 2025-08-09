import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		int[] problems = new int[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();  // count 필요 없어서 버리기 ,,
			while (st.hasMoreTokens())
				problems[i] |= 1 << Integer.parseInt(st.nextToken());
		}

		int answer = Integer.MAX_VALUE, team = 0, target = (1 << (N + 1)) - 2;
		for (int selected = 1; selected < 1 << M; selected++) {
			int result = 0;
			for (int person = 0; person < M; person++) {
				if ((selected & (1 << person)) != 0) {
					team++;
					result |= problems[person];
				}
			}
			
			if (result == target) {
				answer = Math.min(answer, team);				
			}
			team = 0;
		}
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
}