package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FollowingOrders {

	public static ArrayList<Integer> ady[];
	public static String nodos[], adyacencias[];
	public static int map[] = new int[128];
	public static int d[], n;
	public static char res[], unMap[];
	public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int nodo1, nodo2;
		String line = in.readLine();
		StringTokenizer st;

		for (int k = 0; line != null; k++) {
			if (k > 0)
				out.println();
			st = new StringTokenizer(line);
			n = st.countTokens();
			nodos = new String[n];
			for (int i = 0; i < n; i++)
				nodos[i] = st.nextToken();
			st = new StringTokenizer(in.readLine());
			adyacencias = new String[st.countTokens()];
			for (int i = 0; i < adyacencias.length; i++)
				adyacencias[i] = st.nextToken();
			Arrays.sort(nodos);
			unMap = new char[n];
			ady = new ArrayList[n];
			for (int i = 0; i < ady.length; i++)
				ady[i] = new ArrayList<>();

			for (int i = 0; i < nodos.length; i++) {
				map[nodos[i].charAt(0)] = i;
				unMap[i] = nodos[i].charAt(0);
			}
			res = new char[n];
			d = new int[n];
			for (int i = 0; i < adyacencias.length; i += 2) {
				nodo1 = map[adyacencias[i].charAt(0)];
				nodo2 = map[adyacencias[i + 1].charAt(0)];
				d[nodo2]++;
				ady[nodo1].add(nodo2);
			}
			dfs(n);
			line = in.readLine();
		}
		out.close();
		in.close();
	}

	public static void dfs(int l) {
		if (l == 0) {
			out.println(new String(res));
		} else {
			for (int i = 0; i < n; i++) {
				if (d[i] == 0) {
					d[i] = -1;
					res[n - l] = unMap[i];
					for (Integer j : ady[i]) {
						d[j]--;
					}
					dfs(l - 1);
					for (Integer j : ady[i]) {
						d[j]++;
					}
					d[i] = 0;
				}
			}
		}
	}
}
