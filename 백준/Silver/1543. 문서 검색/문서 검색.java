import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	static void init() throws IOException {
		char[] line = br.readLine().toCharArray();
		char[] letters = br.readLine().toCharArray();
		
		solve(line, letters);
	}
	
	static void solve(char[] line, char[] letters) {
		int ans = 0, idx = 0, cur, size = letters.length;
      
		while (idx < line.length - size + 1) {
			if (line[idx] != letters[0]) {
				++idx;
				continue;
			}
			
			for (cur = 0; cur < size; cur++) {
				if (line[idx + cur] != letters[cur]) break;
			}
			
			if (cur == size) {
				++ans;
				idx += size - 1;
			}
          
			++idx;
		}
		
		System.out.println(ans);
	}
}