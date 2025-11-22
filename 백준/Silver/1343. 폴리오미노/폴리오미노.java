import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br; 

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		solve(br.readLine());
	}
	
	static void solve(String line) {
		StringBuilder sb = new StringBuilder();
		
		int cur = -1;
		while (++cur < line.length()) {
			
			if (line.charAt(cur) == '.') {
				sb.append(".");
				continue;
			}
						
			int size = find(line, cur);
			
			if (size < 2 || size % 2 != 0) break;
			sb.append(size == 4 ? "AAAA" : "BB");
			
			cur += size - 1;
		}
		System.out.println(sb.length() == line.length() ? sb : -1);
	}
	
	static int find(String line, int cur) {
		int last;
		
		for (last = cur; last < line.length(); last++) {
			if (line.charAt(last) != line.charAt(cur) || last - cur == 4) break;
		}
		
		return last - cur;
	} 
}