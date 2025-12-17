import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br; 

	static Set<Student> students = new TreeSet<>(Comparator.naturalOrder());
	static Map<Integer, Student> cache = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
	}

	private static void init() throws IOException {
		int N = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int time = 0; time < T; time++) {
			int id = Integer.parseInt(st.nextToken());
			
			// 이미 존재하는 학생
			if (cache.containsKey(id)) {
				Student student = cache.get(id);
				students.remove(student);
				
				++student.recommend;
				students.add(student);
				continue;
			}
			
			// 없을 때
			if (cache.size() >= N) {
				Iterator<Student> iterator = students.iterator();
				Student smaller = iterator.next();
				
				cache.remove(smaller.id);
				students.remove(smaller);
			}
			
			Student freshman = new Student(id, time);
			cache.put(id, freshman);
			students.add(freshman);
		}
		
		Set<Integer> result = new TreeSet(cache.keySet());
		for (int id : result) System.out.print(id + " ");
	}
	
	static class Student implements Comparable<Student>{
		int id, recommend, created;
		
		public Student (int id, int created) {
			this.id = id;
			this.recommend = 1;
			this.created = created;
		}

		@Override
		public int compareTo(Student o) {
			if (this.recommend != o.recommend) return Integer.compare(this.recommend, o.recommend);
			return Integer.compare(this.created, o.created);
		}
	}
}