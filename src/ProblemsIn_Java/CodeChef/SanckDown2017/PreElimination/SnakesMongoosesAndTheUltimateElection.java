package ProblemsIn_Java.CodeChef.SanckDown2017.PreElimination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SnakesMongoosesAndTheUltimateElection {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

//		Scanner in = new Scanner(br);

		int casos = Integer.parseInt(in.readLine().trim());
		for (int c = 0; c < casos; c++) {
			String elections = in.readLine().toLowerCase().trim();
			int snakes = 0, mongooses = 0;
			for (int i = 0; i < elections.length(); i++) {
				if (elections.charAt(i) == 's')
					snakes++;
			}
			mongooses = elections.length() - snakes;
			boolean vis[] = new boolean[snakes + mongooses];
			for (int i = 0; i < elections.length(); i++) {
				if (elections.charAt(i) == 'm') {
					if (i == 0 && elections.length()>1) {
						if (elections.charAt(i + 1) == 's') {
							vis[i+1]=true;
							snakes--;
							continue;
						}
					} else {
						if(i-1 >=0 && elections.charAt(i-1)=='s' && !vis[i-1]){
							vis[i-1]=true;
							snakes--;
							continue;
						}else if(i+1<vis.length && elections.charAt(i+1)=='s'&& !vis[i+1]){
							vis[i+1]=true;
							snakes--;
							continue;
						}
					}
				}
			}
			out.println(snakes == mongooses ? "tie" : (snakes > mongooses ? "snakes" : "mongooses"));
		}

		out.close();
		in.close();
	}
}
