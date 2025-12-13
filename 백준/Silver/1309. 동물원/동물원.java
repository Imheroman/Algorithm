import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br; 

    static final int NONE = 0, LEFT = 1, RIGHT = 2, MOD = 9901;
	static int N;
	static int[][] memorization;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}


	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
        
		memorization = new int[N][3];
		for (int i = 0; i < N; i++) Arrays.fill(memorization[i], -1);

        System.out.println(dp(0, NONE));
	}
	
	static int dp(int r, int c) {
		if (r == N) return 1;
		else if (c != -1 && memorization[r][c] != -1) return memorization[r][c]; 
		
		int result = dp(r + 1, NONE);  // none
		
		if (c != 1) result += dp(r + 1, LEFT);  // left
		if (c != 2) result += dp(r + 1, RIGHT);  // right
		
		return memorization[r][c] = result % MOD;
	}
}