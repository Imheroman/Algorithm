import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	static void init() throws IOException {
		sb = new StringBuilder();
		solve(br.readLine().toCharArray());
	}
	
	static void solve(char[] letters) {
		Deque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < letters.length; i++) {
			if (!isOperator(letters[i])) sb.append(letters[i]);
			else {
				switch (letters[i]) {
				case '(': {
					stack.offerFirst(letters[i]);
					break;
				}
				case ')': {
					popAll(stack);
					break;
				}
				case '+':
				case '-': 
				case '*': 
				case '/': {
					comparePop(stack, letters[i]);
					break;
					}
				}
			}
		}
		
		popAll(stack);
		System.out.println(sb);
	}
	
	static void comparePop(Deque<Character> stack, char c) {
	    while (!stack.isEmpty() && stack.peekFirst() != '(') {
	        char top = stack.peekFirst();
            
	        if ((c == '*' || c == '/') && (top == '+' || top == '-')) break;
	        sb.append(stack.pollFirst());
	    }
        
	    stack.offerFirst(c);
	}
	
	static void popAll(Deque<Character> stack) {
		while (!stack.isEmpty()) {
			char cur = stack.poll();

			if (cur == '(') return;
			else sb.append(cur);
		}
	}

	static boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')';
	}
}