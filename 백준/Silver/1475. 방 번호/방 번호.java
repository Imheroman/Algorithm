import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int N;
	static int[] numbers;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
	}

	public static void init() throws IOException {  // 입력 받기
		numbers = new int[10];
		N = Integer.parseInt(br.readLine());
		
		while (N > 0) {
            ++numbers[N % 10];
			N /= 10;
		}

		numbers[6] = (numbers[6] + numbers[9] + 1) / 2;
	}
	
	public static void solve() {
		int max = 0;
		
		for (int i = 0; i < 9; i++) max = max > numbers[i] ? max : numbers[i]; 
		
		System.out.println(max);
	}
}