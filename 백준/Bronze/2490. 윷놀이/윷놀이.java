import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            int cnt = 0;

            char[] nums = br.readLine().toCharArray();

            for (char n : nums) if (n == '0') ++cnt;

            if (cnt == 0) System.out.println("E");
            else if (cnt == 1) System.out.println("A");
            else if (cnt == 2) System.out.println("B");
            else if (cnt == 3) System.out.println("C");
            else System.out.println("D");
        }
    }
}