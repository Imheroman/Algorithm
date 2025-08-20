import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n;

		StringBuilder answer = new StringBuilder();
		List<String> list = new ArrayList();
		while ((n = getInt()) > 0) {
			list.sort(String::compareToIgnoreCase);
			for (int i = 0; i < n; i++) {
				list.add(br.readLine());
			}
			
			list.sort(String::compareToIgnoreCase);
			answer.append(list.get(0)).append("\n");
			list.clear();
		}
		
		System.out.println(answer);
	}

	public static int getInt() throws IOException {
		return Integer.parseInt(br.readLine());
	}
}