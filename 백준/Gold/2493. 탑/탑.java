import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        init();
    }

    static void init() throws IOException {
        sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int[] towers = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) towers[i] = Integer.parseInt(st.nextToken());
        
        solve(N, towers);
    }
    
    // 1. stack이 비어있지 않으면 나보다 큰 타워가 나올 때 까지 확인 
    static void solve(int N, int[] towers) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for (int cur = 0; cur < N; cur++) {
            while (!stack.isEmpty() && towers[cur] >= towers[stack.peekLast()]) stack.pollLast();
            
            sb.append(stack.isEmpty() ? 0 : stack.peekLast() + 1).append(" ");
            stack.offer(cur);
        }
        
        System.out.println(sb);
    }
}