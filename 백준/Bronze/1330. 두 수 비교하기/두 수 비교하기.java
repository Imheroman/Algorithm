import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		java.util.StringTokenizer st = new java.util.StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
		
		if (a > b) {
			System.out.println(">");
		} else if (a < b) {
			System.out.println("<");
		} else {
			System.out.println("==");
		}
	}
}