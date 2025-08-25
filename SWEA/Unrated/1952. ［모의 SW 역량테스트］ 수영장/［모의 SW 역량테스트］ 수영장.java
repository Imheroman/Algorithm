import java.io.*;
import java.util.*;
 
public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static int DALIY = 0, MONTHLY = 1, MONTHLY_3 = 2, YEARLY = 3;  // index
    static int[] costs, monthly, dp;  // 비용 저장, 월 이용 일수 저장, 최솟값 저장
     
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= T; t++) {
            init();
            solve();
            System.out.println(String.format("#%d %d", t, dp[12]));
        }
    }
     
    public static void init() throws IOException {
        costs = new int[4];  // 일, 월, 3월, 12월 단위의 비용 저장
        monthly = new int[13];  // 월단위로 이용하는 일수 저장
        dp = new int[13];  // 최솟값 저장 크기 초기화
         
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            costs[i] = Integer.parseInt(st.nextToken());
         
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < 13; i++)
            monthly[i] = Integer.parseInt(st.nextToken());
    }
     
    static void solve() {
        dp[1] = dp[0] + Math.min(monthly[1]* costs[DALIY], costs[MONTHLY]);  // 1월과
        dp[2] = dp[1] + Math.min(monthly[2]* costs[DALIY], costs[MONTHLY]);  // 2월은 일과 월로만 판단하여 저장
         
        for (int i = 3; i < 13; i++) {  // 3월부터 반복문 시작
            int day = dp[i - 1] + monthly[i]* costs[DALIY];  // 일 수로 계산
            int month = dp[i - 1] + costs[MONTHLY];  // 월 값으로 계산
            int month3 = dp[i - 3] + costs[MONTHLY_3];  // 3개월 전 값에 + 3개월 값으로 계산
             
            int min = day < month ? day : month;
            dp[i] = min < month3 ? min : month3;  // 3개의 값 중 가장 최솟값 찾아서 저장하기
        }
        
        dp[12] = Math.min(dp[12], costs[YEARLY]);  // 모두 계산한 값이 1년 단위보다 비싼 경우 확인하기
        // github upload test code
    }
}