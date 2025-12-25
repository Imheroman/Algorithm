import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int length = br.readLine().length();
			sb.append(6 <= length && length <= 9 ? "yes" : "no").append("\n");
		}
		
		System.out.println(sb);
	}
}