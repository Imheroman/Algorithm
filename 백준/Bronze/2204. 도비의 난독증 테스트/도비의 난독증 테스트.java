import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n;

		while ((n = getInt()) > 0) {
			SortedMap<String, String> map = new TreeMap<>();
			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				map.put(line.toLowerCase(), line);
			}
			
			System.out.println(map.get(map.firstKey()));
		}
	}

	public static int getInt() throws IOException {
		return Integer.parseInt(br.readLine());
	}
}