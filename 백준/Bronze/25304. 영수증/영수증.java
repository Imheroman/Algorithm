import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int result = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			java.util.StringTokenizer st = new java.util.StringTokenizer(br.readLine());
			int price = Integer.parseInt(st.nextToken()),
					stock = Integer.parseInt(st.nextToken());
			
			result -= price * stock;
		}
		
		System.out.println(result == 0 ? "Yes" : "No");
	}
}