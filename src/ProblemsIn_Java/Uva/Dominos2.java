package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Dominos2 {

	static boolean mAdy[][],visit[];
	static int goal;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		ArrayList<Integer> golpear;
		int casos = Integer.parseInt(in.readLine());
		for (int i = 0; i < casos; i++) {

			st = new StringTokenizer(in.readLine());

			int nodos = Integer.parseInt(st.nextToken());
			mAdy = new boolean[nodos][nodos];
			visit= new boolean [ nodos];

			int aristas = Integer.parseInt(st.nextToken());
			int golpeados = Integer.parseInt(st.nextToken());

			for (int j = 0; j < aristas; j++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				mAdy[x][y] = true;
				// se puede arreglar y x
			}

			goal = 0;
			golpear = new ArrayList<>();
			for (int j = 0; j < golpeados; dfs(Integer.parseInt(in.readLine().trim())-1), j++);

			out.println(goal);

		}

		out.close();
		in.close();
	}

	static void dfs (int ini){
		if(!visit[ini]){
			goal++;
			visit[ini]=true;
			for (int i = 0; i < mAdy[ini].length; i++) {
				if(mAdy[ini][i]){
					dfs(i);
				}
			}
		}
	}

}
