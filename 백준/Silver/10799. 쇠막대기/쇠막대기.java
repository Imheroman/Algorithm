import java.io.*;
import java.util.*;

public class Main {
	static char[] letters;

	public static void main(String[] args) throws IOException {
		init();
		solve();
	}
	
	public static void init() throws IOException{
		letters = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
	}
	
	public static void solve() {
		int cnt = 0, ans = 0;
		
		for (int i = 0; i < letters.length; i++) {
			if (letters[i] == '(') ++cnt;
			else if (letters[i - 1] == '(' && letters[i] == ')') ans += --cnt;
			else if(letters[i - 1] == ')' && letters[i] == ')') {
				--cnt;
				++ans;
			}
		}
		
		System.out.println(ans);
	}
}