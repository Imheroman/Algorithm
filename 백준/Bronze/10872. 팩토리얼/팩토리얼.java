import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		System.out.println(dfs(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())));
	}
	
	public static int dfs(int n) {
		return (n <= 1) ? 1 : n * dfs(n - 1);
	}
}