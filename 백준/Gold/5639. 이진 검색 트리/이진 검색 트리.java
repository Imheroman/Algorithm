import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String line;
		int[] numbers = new int[10001];

		int i = 0;
		while ((line = br.readLine()) != null && !line.isEmpty()) {
			numbers[i++] = Integer.parseInt(line);
		}
		postorder(numbers, 0, i);
	}

	private static void postorder(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		
		boolean flag = false;
		int index = 0;
		for (int current = start; current < end; current++) {
			if (arr[start] < arr[current]) {
				flag = true;
				index = current;
				break;
			}
		}
		
		if (flag) {
			postorder(arr, start + 1, index);
			postorder(arr, index, end);
		} else {
			postorder(arr, start + 1, end);
		}
		
		System.out.println(arr[start]);
	}
}