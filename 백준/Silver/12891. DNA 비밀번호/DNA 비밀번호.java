import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static final Map<Character, Integer> PASSWORD_POSITION = new HashMap();
	
	static {
		PASSWORD_POSITION.put('A', 0);
		PASSWORD_POSITION.put('C', 1);
		PASSWORD_POSITION.put('G', 2);
		PASSWORD_POSITION.put('T', 3);
	}

	public static void main(String[] args) throws IOException { 
		st = input();
		int n = getInt(st), range = getInt(st);
		String line = br.readLine();
		st = input();
		int[] limit = new int[4];
		for (int i = 0; i < 4; i++) {
			limit[i] = getInt(st);
		}
		
		for (int i = 0; i < range; i++) {
			limit[PASSWORD_POSITION.get(line.charAt(i))]--;
		}
		
		int answer = 0;
		for (int current = range; current <= n; current++) {
			answer++;
			
			for (int i = 0; i < limit.length; i++) {
				if (limit[i] > 0) {
					answer--;
					break;
				}
			}
			
			if (current < n) {
				limit[PASSWORD_POSITION.get(line.charAt(current - range))]++;
				limit[PASSWORD_POSITION.get(line.charAt(current))]--;				
			}
		}
		
		System.out.println(answer);
	}
	
	public static StringTokenizer input() throws IOException {
		return new StringTokenizer(br.readLine());
	}
	
	public static int getInt(StringTokenizer s) {
		return Integer.parseInt(s.nextToken());
	}
}