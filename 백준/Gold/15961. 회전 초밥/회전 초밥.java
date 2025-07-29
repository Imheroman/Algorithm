import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = input();
		int N = getInt(st), d = getInt(st), k = getInt(st), c = getInt(st);
		int[] belts = new int[N];
		int[] memorization = new int[d + 1];
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			int current = getInt();
			
			if (i < k) {
				if (memorization[current] == 0) {
					count++;					
				}
				memorization[current]++;
			}
			
			belts[i] = current;
		}
		
		int answer = memorization[c] == 0 ? count + 1 : count;
		for (int i = k; i < N + k; i++) {
			int current = belts[i % N];
			
			memorization[belts[(i - k) % N]]--;
			
			if (memorization[belts[(i - k) % N]] == 0) {
				count--;
			}
			
			memorization[current]++;
			
			if (memorization[current] == 1) {
				count++;
			}
			
			answer = Math.max(answer, memorization[c] == 0 ? count + 1 : count);
		}
		
		System.out.println(answer);
	}
	
	public static StringTokenizer input() throws IOException {
		return new StringTokenizer(br.readLine());
	}

	public static int getInt(StringTokenizer s) {
		return Integer.parseInt(s.nextToken());
	}

	public static int getInt() throws IOException {
		return Integer.parseInt(br.readLine());
	}
}