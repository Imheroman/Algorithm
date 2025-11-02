import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
		
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	static void init() throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		String[] parentheses = new String[N];
		for (int i = 0; i < N; i++) parentheses[i] = br.readLine(); 
		
		solve(parentheses);
	}
  
	static void solve(String[] parentheses) {
		for (String parenthesis : parentheses) {
			if (isValidParenthesis(parenthesis)) sb.append("YES");
			else sb.append("NO");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	static boolean isValidParenthesis(String parenthesis) {
		ArrayDeque<Character> stack = new ArrayDeque<>();
		
		for (int cur = 0; cur < parenthesis.length(); cur++) {
			if (parenthesis.charAt(cur) == '(') stack.offer('(');
			else {
				if (stack.isEmpty()) return false; 
				else stack.pollLast();
			}
		}
		
		return stack.isEmpty() ? true : false;
	}
}