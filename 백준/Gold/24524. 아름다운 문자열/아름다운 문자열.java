import java.io.*;
import java.util.*;

// gemini 아이디어 
public class Main {
	private static BufferedReader br; 
	
	static char[] S, T;
	static int[] tPos, prefix;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	private static void init() throws IOException {
		S = br.readLine().toCharArray();
		T = br.readLine().toCharArray();
		
		prefix = new int[T.length];
		tPos = new int[26];
		
		Arrays.fill(tPos, -1);  // 구분하기 위한 값. -1이면 T에 없는 값임 
		for (int i = 0; i < T.length; i++) tPos[T[i] - 'a'] = i;  // i번째 문자열의위치 저 
		
		solve();
	}
	
	static void solve() {
		for (char s : S) {
			int id = tPos[s - 'a'];
			
			if (id == 0) ++prefix[id];  // 처음 인덱스이거나
			else if (id > 0 && prefix[id - 1] > 0){  // 이전 인덱스를 이미 거쳐왔다면..
				--prefix[id - 1];
				++prefix[id];
			}
		}
		
		System.out.println(prefix[T.length - 1]);
	}
}