import java.io.*;

public class Main {
	static int N;

	public static void main(String[] args) throws IOException{
		init();
		System.out.println(dfs(N));
	}
	
	public static void init() throws IOException{
		N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		
	}
	
	public static int dfs(int n) {
		return (n <= 1) ? 1 : n * dfs(n - 1);
	}
}