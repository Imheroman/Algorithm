import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	static final int MAX_SIZE = 1_000_001;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        
		int[] numbers = new int[MAX_SIZE];
		before(numbers);
		
		int n;
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			
            sb.append(numbers[n]).append("\n");
		}
        
        System.out.println(sb);
	}
	
	static void before(int[] numbers) {
		Set<Integer> set = new HashSet<>();
		int number = 0, cnt;
		
		for (int cur = 1; cur < MAX_SIZE; cur++) {
			while (true) {
				if (bt(++number, 0)) break;
			}
			
			numbers[cur] = number;
		}
	}
	
	static boolean bt(int number, int flag) {
		if (number == 0) return true;
		
		int bit = 1 << (number % 10);
		if ((flag & bit) == 0) return bt(number / 10, flag | bit);
		else return false;
	}
}