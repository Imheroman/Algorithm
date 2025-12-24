import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Set<Integer> xSet = new HashSet<>();
		Set<Integer> ySet = new HashSet<>();
		
		int[] ans = new int[2];
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken()),
					y = Integer.parseInt(st.nextToken());
			
			if (xSet.contains(x)) xSet.remove(x);
			else xSet.add(x);
			
			if (ySet.contains(y)) ySet.remove(y);
			else ySet.add(y);
			
		}
		
		for (int x : xSet) System.out.print(x + " ");
		for (int y : ySet) System.out.println(y);
	}
}