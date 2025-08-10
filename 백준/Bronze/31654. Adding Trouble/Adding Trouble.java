import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		java.util.StringTokenizer st = new java.util.StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		boolean same = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) == Integer.parseInt(st.nextToken());
		System.out.println(same ? "correct!" : "wrong!");
	}
}