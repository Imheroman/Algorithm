import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] people = new ArrayList[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			people[i] = new ArrayList<>();
			while (st.hasMoreTokens())
				people[i].add(Integer.parseInt(st.nextToken()));
		}

		int answer = Integer.MAX_VALUE, team = 0;
		Set<Integer> problems = new HashSet<>();
		for (int selected = 1; selected < 1 << M; selected++) {
			for (int person = 0; person < M; person++) {
				if ((selected & (1 << person)) != 0) {
					team++;
					for (int problem : people[person]) {
						problems.add(problem);
					}
				}
			}
			
			if (problems.size() == N) {
				answer = Math.min(answer, team);				
			}
			problems.clear();
			team = 0;
		}
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
}