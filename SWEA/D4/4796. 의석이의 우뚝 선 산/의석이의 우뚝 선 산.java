import java.util.*;
import java.io.FileInputStream;

public class Solution {
	static Scanner sc;
	static StringBuilder sb;
	static int N, answer;
	static int[] numbers;

	public static void main(String[] args) throws Exception {
        sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			init();
			solve();
			System.out.println(String.format("#%d %d", t, answer));
		}
	}

	public static void init() {
		answer = 0;

		N = sc.nextInt();
		numbers = new int[N];

		for (int i = 0; i < N; i++)
			numbers[i] = sc.nextInt();
	}

	static void solve() {
    int l = 0, mid = 0, r = 0;

        while (l + 1 < N) {
            while (mid + 1 < N && numbers[mid] < numbers[mid + 1]) ++mid;
            if (mid == l) { 
                mid = ++l;
                continue;
            }

            r = mid;

            while (r + 1 < N && numbers[r] > numbers[r + 1]) ++r;
            if (r == mid) { 
                l = ++mid;
                continue;
            }

            answer += (mid - l) * (r - mid);

            l = r;
            mid = r;
        }
	}

}