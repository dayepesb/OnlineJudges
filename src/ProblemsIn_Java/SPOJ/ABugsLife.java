package ProblemsIn_Java.SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author David Yepes Buitrago
 * 
 * @Date 28-07-2017
 * 
 * esto solo pasa en c++
 */
public class ABugsLife {
	static ArrayList<Integer> ady[];
	static int sexo[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int t = Integer.parseInt(in.readLine().trim()), n, m;
		for (int c = 0; c < t; c++) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			ady = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				ady[i] = new ArrayList<>();
			}
			int x, y;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine());
				x = Integer.parseInt(st.nextToken()) - 1;
				y = Integer.parseInt(st.nextToken()) - 1;
				ady[x].add(y);
				ady[y].add(x);
			}
			boolean hetero = true;
			sexo = new int[n];
			for (int i = 0; i < n; i++) {
				if (sexo[i] == 0) {
					sexo[i] = 1;
					hetero = (hetero && dfs(i));
					if (!hetero)
						break;
				}
			}
			out.printf("Scenario #%d:%n",c+1);
			if (hetero)
				out.printf("No suspicious bugs found!\n");
			else
				out.printf("Suspicious bugs found!\n");
		}

		in.close();
		out.close();
	}

	/**
	 * @param i
	 * @return
	 */
	private static boolean dfs(int v) {
		boolean hetero = true;
		for (Integer w : ady[v]) {
			if (sexo[w] == sexo[v])
				return false;
			if (sexo[w] == 0) {
				sexo[w] = (sexo[v] * -1);
				hetero = (hetero && dfs(w));
			}
		}
		return hetero;
	}
}
