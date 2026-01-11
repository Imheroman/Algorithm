import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        String resultCount = "";
        String resultProblems = "";

        switch (n) {
            case 1:
                System.out.println(11);
                System.out.println("A B C D E F G H J L M");
                break;
            case 2:
            case 3:
                System.out.println(9);
                System.out.println("A C E F G H I L M");
                break;
            case 4:
                System.out.println(9);
                System.out.println("A B C E F G H L M");
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                System.out.println(8);
                System.out.println("A C E F G H L M");
                break;
            case 10:
                System.out.println(8);
                System.out.println("A B C F G H L M");
                break;
            default:
                System.out.println(0);
                System.out.println("");
        }
    }
}
