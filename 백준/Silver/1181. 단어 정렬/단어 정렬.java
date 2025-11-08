import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        init();
    }

    static void init() throws IOException {
    	sb = new StringBuilder();
    	
    	Set<String> set = new TreeSet<>(Comparator.comparingInt(String::length)
    			.thenComparing(Comparator.naturalOrder()));
    	
    	int N = Integer.parseInt(br.readLine());
    	for (int i = 0; i < N; i++) set.add(br.readLine());
        
    	for (String line : set) sb.append(line).append("\n");
    	System.out.println(sb);
    }
}