import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb;
	static int[] nNumbers, mNumbers, numbers;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	static void init() throws IOException {
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		nNumbers = new int[n];
		mNumbers = new int[m];
		numbers = new int[n + m];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) nNumbers[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) mNumbers[i] = Integer.parseInt(st.nextToken());
		solve();
	}
	
	static void solve() {
		int n = 0, m = 0, i = 0;
		
		while (n < nNumbers.length && m < mNumbers.length) 
			numbers[i++] = nNumbers[n] < mNumbers[m] ? 
					nNumbers[n++] : mNumbers[m++];
		
		while (n < nNumbers.length) numbers[i++] = nNumbers[n++];
		while (m < mNumbers.length) numbers[i++] = mNumbers[m++];
			
		for (int number : numbers) sb.append(number).append(" ");
		System.out.println(sb);
	}
}