import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = getInt();
		int[] tops = new int[N];
		int[] answer = new int[N];
		List<Integer> stack = new ArrayList();

		st = input();
		for (int i = 0; i < N; i++) {
			tops[i] = getInt(st);
		}
        
		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && tops[stack.get(stack.size() - 1)] <= tops[i]) {
				stack.remove(stack.size() - 1);
			}

			if (!stack.isEmpty()) {
				answer[i] = stack.get(stack.size() - 1) + 1;
			}
			
			stack.add(i);
		}

        StringBuilder sb = new StringBuilder();
		for (int number : answer) {
            sb.append(number).append(" ");
		}
        
        System.out.println(sb);
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