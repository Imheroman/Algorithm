import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    
    static final int GENDER = 0, POS = 1, MAN = 1, WOMAN = 2;
    
    static int N, cn;
    static int[][] commands;
    static boolean[] switches;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        init();
    }

    static void init() throws IOException {
        sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        switches = new boolean[N + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) switches[i] = Integer.parseInt(st.nextToken()) == 1;
        
        cn = Integer.parseInt(br.readLine());
        commands = new int[cn][2];
        for (int i = 0; i < cn; i++) {
            st = new StringTokenizer(br.readLine());
            commands[i][GENDER] = Integer.parseInt(st.nextToken());
            commands[i][POS] = Integer.parseInt(st.nextToken());
        }
        
        solve();
    }
    
    static void solve() {
        for (int[] command : commands) {
            if (command[GENDER] == MAN) man(command[POS]);
            else woman(command[POS]);
        }
      
        for (int i = 1; i < N + 1; i++) {
        	sb.append(switches[i] ? 1 : 0).append(" ");
        	if (i % 20 == 0) sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void woman(int pos) {
        int left = pos, right = pos;
        
        while (isValidRange(--left, ++right) && switches[left] == switches[right]) {
        	boolean res = !switches[left];
            switches[left] = switches[right] = res;
        }
        
        switches[pos] = !switches[pos];
    }

    private static void man(int pos) {
        int idx = pos;
        
        while (idx < N + 1) {
            switches[idx] = !switches[idx];
            idx += pos;
        }
    }
    
    static boolean isValidRange(int left, int right) {
        return 1 <= left && left < N + 1 && 1 <= right && right < N + 1;
    }
}