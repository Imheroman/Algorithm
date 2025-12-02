import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N * 2; i++) col(N);  // hair
		row(N);
		for (int i = 0; i < N; i++) col(N);  // nose
		row(N);
		
		System.out.println(sb);
	}
	
	public static void col(int N) {
		for (int j = 0; j < N; j++) sb.append("@");  // left
		for (int j = 0; j < N * 3; j++) sb.append(" ");  // middle space
		for (int j = 0; j < N; j++) sb.append("@");  // right
		sb.append("\n");
	}
	
	public static void row(int N) {
		for (int i = 0; i < N; i++) { 
			for (int j = 0; j < N * 5; j++) sb.append("@");  
			sb.append("\n");
		}
	}
}