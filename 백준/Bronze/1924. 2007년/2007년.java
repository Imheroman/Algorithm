import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static final int[] MONTHLY_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	static final String[] WEEKEND = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}
	
	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		
		solve(month, day);
	}
	
	static void solve(int month, int day) {
		int sum = day;
		while (--month  > 0) sum += MONTHLY_DAYS[month];
		
		System.out.println(WEEKEND[sum % WEEKEND.length]);
	}
}