import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n;

		while ((n = getInt()) > 0) {
			List<String> list = new ArrayList();
			list.sort(String::compareToIgnoreCase);
			for (int i = 0; i < n; i++) {
				list.add(br.readLine());
			}
			
			list.sort(String::compareToIgnoreCase);
			System.out.println(list.get(0));
		}
	}
	
	public static int getInt() throws IOException {
		return Integer.parseInt(br.readLine());
	}
}