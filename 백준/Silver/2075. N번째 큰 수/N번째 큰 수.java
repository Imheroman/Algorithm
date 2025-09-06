import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int[] numbers;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
		System.out.println(numbers[N * N - N]);
	}

	public static void init() throws IOException {  // 입력 받기
		N = Integer.parseInt(br.readLine());
		
		numbers = new int[N * N];
		int index;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			index = i * N;

			for (int j = 0; j < N; j++) numbers[index + j] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
	}
}