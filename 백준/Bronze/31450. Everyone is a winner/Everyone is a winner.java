import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		java.util.StringTokenizer st = new java.util.StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.println(Integer.parseInt(st.nextToken()) % Integer.parseInt(st.nextToken()) == 0 ? "Yes" : "No");
	}
}