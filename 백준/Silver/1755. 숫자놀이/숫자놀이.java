import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb;
	static String[] NUMBER_DIRECTION = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "onezero"};
	static Set<String> keyset;
	static Map<String, Integer> numberMap;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		System.out.println(sb);			
	}
	

	static void init() throws IOException {
		sb = new StringBuilder();
		keyset = new TreeSet<>();
		numberMap = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		
		for (int number = n; number < m + 1; number++) {
			String key = makeKey(number);
			keyset.add(key);
			numberMap.put(key, number);
		}
	}
	
	static void solve() {
		int cnt = 0;
		for (String num : keyset) {
			sb.append(numberMap.get(num)).append(" ");
			if(++cnt % 10 == 0) sb.append("\n");
		}
	}
	
	static String makeKey(int n) {
		if (n <= 10) return NUMBER_DIRECTION[n]; 
        
		StringBuilder key = new StringBuilder();
		String number = "";
		while (n > 0) {
			number = number.concat(NUMBER_DIRECTION[n % 10]).concat(" ");
			n /= 10;
		}
        
		String[] res = number.split(" ");
		for (int i = res.length - 1; i >= 0; i--) key.append(res[i]);
		
		return key.toString();
	} 
}