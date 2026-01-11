import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static List<List<Player>> teams = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			solve(new Player(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		StringBuilder sb = new StringBuilder();
		for (List<Player> t : teams) {
			t.sort((p1, p2) -> p1.name.compareTo(p2.name));
			sb.append(t.size() == M ? "Started!" : "Waiting!").append("\n");
			for (Player p : t) sb.append(p.level).append(" ").append(p.name).append("\n");				
		}
		
		System.out.println(sb);
	}
	
	static void solve(Player player) {
		for (List<Player> team : teams) {
			Player leader = team.get(0);
			
			if (Math.abs(leader.level - player.level) <= 10 && team.size() < M) {
				team.add(player);
				return;
			}
		}
		
		List<Player> team = new ArrayList<>();
		team.add(player);
		teams.add(team);
	}
	
	static class Player {
		int level;
		String name;
		
		public Player(int level, String name) {
			this.level = level;
			this.name = name;
		}
	}
}