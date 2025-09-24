import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	static final int MAX_RANGE = 10_005;
	static BigInteger[] fibos = new BigInteger[MAX_RANGE];
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		fibos[2] = fibos[1] = BigInteger.ONE;
		for (int i = 3; i < MAX_RANGE; i++) fibos[i] = fibos[i - 1].add(fibos[i - 2]);
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) init(t);
		System.out.println(sb);
	}
	
	static void init(int t) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		String q = st.nextToken();
		
		sb.append("Case #").append(t).append(": ").append(fibos[n].mod(new BigInteger(q))).append("\n");
	}
}