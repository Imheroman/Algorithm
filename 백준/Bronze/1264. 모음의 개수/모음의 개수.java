import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br; 
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	private static void init() throws IOException {
		sb = new StringBuilder();
		
		while (true) {
			String line = br.readLine();
			
			if (line.equals("#")) break;
			sb.append(solve(line.toLowerCase())).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int solve(String line) {
		int cnt = 0;
		
		for (int i = 0; i < line.length(); i++) {
			char key = line.charAt(i);
			
			if (key == 'a' || key == 'e' || key == 'i' || key == 'o' || key == 'u') ++cnt;
		}
		
		return cnt;
	} 
}