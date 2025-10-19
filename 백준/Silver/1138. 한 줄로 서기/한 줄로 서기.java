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
		int[] answer = new int[N];
		for (int cur = 0; cur < N; cur++) {  // 현재 차례의 사람 
			int taller = 0;  // 나보다 키 큰 사람 카운트 
			
			for (int p = 0; p < N; p++) {  // 방문하는 사람
				if (answer[p] == 0 && people[cur] == taller) {  // 해당 자리가 비었고, 나보다 키큰 사람의 카운트가 동일할 때
					answer[p] = cur + 1;
					break;
				}
				else if (answer[p] == 0) ++taller;
			}
		}
		
		for (int number : answer) System.out.print(number + " ");
	}
}
