import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        init();
    }

    static void init() throws IOException {
    	int N = Integer.parseInt(br.readLine());
        int[] buildings = new int[N];
    	for (int i = 0; i < N; i++) buildings[i] = Integer.parseInt(br.readLine());
    	
    	solve(buildings);
    }
    
    static void solve(int[] buildings) {
    	long ans = 0;
    	ArrayDeque<Integer> stack = new ArrayDeque<>();
    	
    	for (int building : buildings) {
    		while(!stack.isEmpty() && stack.peekLast() <= building) stack.pollLast();
    		stack.offer(building);    		
			
    		ans += stack.size() - 1;
    	}
    	
    	System.out.println(ans);
    }
}