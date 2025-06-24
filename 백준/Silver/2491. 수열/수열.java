import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.BiPredicate;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> numbers = new ArrayList<>();
        st.asIterator().forEachRemaining(val -> numbers.add(Integer.parseInt((String) val)));

        int[] decrement = new int[size];
        int[] increment = new int[size];
        decrement[0] = 1;
        increment[0] = 1;

        for (int i = 1; i < size; i++) {
            int pre = numbers.get(i - 1);
            int current = numbers.get(i);

            increment[i] = increment[i - 1] + 1;
            decrement[i] = decrement[i - 1] + 1;

            if (current > pre) {
                decrement[i] = 1;
            }

            if (current < pre) {
                increment[i] = 1;
            }
        }
        
        System.out.println(Math.max(Arrays.stream(increment).max().orElse(1), Arrays.stream(decrement).max().orElse(1)));
    }
}