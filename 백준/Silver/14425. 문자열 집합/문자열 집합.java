import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> repository = new HashSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()),
				M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) repository.add(br.readLine());
		
		int answer = 0;
		for (int m = 0; m < M; m++) {			
			if (repository.contains(br.readLine())) ++answer; 
		}
		
		System.out.println(answer);
	}
}