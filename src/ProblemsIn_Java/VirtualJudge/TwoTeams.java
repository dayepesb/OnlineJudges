package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 01-08-2017
 * @time 0.109 ms
 */
public class TwoTeams {
	static char[] equipo;
	static ArrayList<Integer>[] lAdy;

	public static void main(String[] args) throws Exception {
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		int nodos;
		for (String line; (line = tec.readLine()) != null;) {
			nodos = Integer.parseInt(line.trim());
			lAdy = new ArrayList[nodos];
			for (int i = 0; i < nodos; lAdy[i] = new ArrayList<>(), i++)
				;

			for (int i = 0; i < nodos; i++) {
				st = new StringTokenizer(tec.readLine());
				int n = Integer.parseInt(st.nextToken());
				while (n != 0) {
					lAdy[i].add(n - 1);
					n = Integer.parseInt(st.nextToken());
				}
			}
			equipo = new char[nodos];

			for (int i = 0; i < lAdy.length; i++) {
				if (equipo[i] == 0) {
					equipo[i] = 'a';
					dfs(i);
				}
			}
			ArrayList<Integer> sol = new ArrayList<>();
			for (int i = 0; i < equipo.length; i++) {
				if (equipo[i] == 'a') {
					sol.add(i);
				}
			}

			out.println(sol.size());
			for (int i = 0; i < sol.size(); i++) {
				out.print(sol.get(i) + 1);
				if (i < sol.size() - 1) {
					out.print(" ");
				}
			}
			out.println();
		}
		out.close();
	}

	private static void dfs(int i) {
		for (int v : lAdy[i]) {
			if (equipo[i] == 'a' && equipo[v] == 0) {
				equipo[v] = 'b';
				dfs(v);
			}
			if (equipo[i] == 'b' && equipo[v] == 0) {
				equipo[v] = 'a';
				dfs(v);
			}
		}
	}
}
