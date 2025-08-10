import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		int range = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		if (range >= 620 && range <= 780) {
			System.out.println("Red");
		} else if (range >= 590) {
			System.out.println("Orange");
		} else if (range >= 570) {
			System.out.println("Yellow");
		} else if (range >= 495) {
			System.out.println("Green");
		} else if (range >= 450) {
			System.out.println("Blue");
		} else if (range >= 425) {
			System.out.println("Indigo");
		} else if (range >= 380) {
			System.out.println("Violet");
		} 
	}
}