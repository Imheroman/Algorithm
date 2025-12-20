import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br; 
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}
	
	private static void init() throws IOException {
		int N = Integer.parseInt(br.readLine());
		Set<Student> students = new TreeSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int id = 0; id < N; id++) {
			int last = Integer.parseInt(st.nextToken());
			students.add(new Student(id + 1, last));
		}
		
		solve(students);
	}
    
	static void solve(Set<Student> students) {
		StringBuilder sb = new StringBuilder();
		
		for (Student s : students) sb.append(s.last - s.mid).append("\n");
		
		System.out.println(sb);
	}
	
	static class Student implements Comparable<Student>{
		int mid, last;

		public Student(int mid, int last) {
			this.mid = mid;
			this.last = last;
		}

		@Override
		public int compareTo(Main.Student o) {
			return Integer.compare(this.last, o.last);
		}
	}
}