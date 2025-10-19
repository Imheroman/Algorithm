import java.io.*;
import java.util.*;

/*
- 왼쪽에 몇 명 있었는지 주어짐
아 .. 일단 해당하는 사람이 있는지 확인하고, 없으면 가장 작은 값 들고 있는 사람 불러오면 될 듯?
그런데, 똑같은 인덱스 값이 있으면 더 작은 거
똑같은 인덱스 값이 없으면 그냥 가장 작은 수 ?

---

아니면, 해당 인덱스에 방문하면 ,, 그냥 다 큐에 넣음 ? -> 이거인

--- 

그냥 다 아님 
입력받은 순서대로 앞에 나보다 큰 사람 있는지 확인하고
해당 자리에 넣기 ..

실은 이해가 잘 되진 않음 
https://velog.io/@guswlsdl0121/%EB%B0%B1%EC%A4%80-1138%EB%B2%88-%ED%95%9C-%EC%A4%84%EB%A1%9C-%EC%84%9C%EA%B8%B0-with-Java
그림으로 잘 설명해주셨음 

https://www.acmicpc.net/source/99479792 -> 이분 코드가 더 쉬움 ..
 */
public class Main {
	static BufferedReader br;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	static void init() throws IOException {
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] people = new int[N]; 
		for (int i = 0; i < N; i++) people[i] = Integer.parseInt(st.nextToken());  // 키 순서 저장
		
		solve(people, N);
	}

	static void solve(int[] people, int N) {
		List<Integer> ans = new ArrayList<>(); // 줄을 세울 ArrayList line		
		for(int i = N - 1; i >= 0; i--) ans.add(people[i], i + 1); //키가 i인 사람을 인덱스 tall[i]번째에 삽입한다
        
		for (int number : ans) System.out.print(number + " ");
	}
}