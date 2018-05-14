package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 31-07-2017
 * @time 0.110 ms
 */
public class ErdosEtAl {
	static int articulos, personas;
	static ArrayList<Integer>[] lAdy;
	static int vis[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		for (String line; (line = in.readLine()) != null;) {
			st = new StringTokenizer(line);
			articulos = Integer.parseInt(st.nextToken());
			personas = Integer.parseInt(st.nextToken());
			lAdy = new ArrayList[articulos + personas];
			for (int i = 0; i < lAdy.length; i++) {
				lAdy[i] = new ArrayList<>();
			}
			for (int i = 0; i < articulos; i++) {
				st = new StringTokenizer(in.readLine());
				st.nextToken();
				while (st.hasMoreTokens()) {
					int u = Integer.parseInt(st.nextToken()) - 1;
					lAdy[u].add(i + personas);
					lAdy[i + personas].add(u);
				}
			}
			bfs();
			// System.out.println(Arrays.toString(vis));
			int d = 0;
			int m = -1;
			int s = 0;
			for (int i = 0; i < personas; i++) {
				if (vis[i] != -1) {
					s += vis[i];
					d++;
					m=Math.max(m, vis[i]);
				}
				
			}
			out.printf("%d %d %d%n",d,m,s);
		}

		in.close();
		out.close();
	}

	static void bfs() {
		vis = new int[personas + articulos];
		Arrays.fill(vis, -1);
		Deque<Integer> dq = new ArrayDeque<>();
		vis[0] = 0;
		dq.addLast(0);
		while (!dq.isEmpty()) {
			int u = dq.poll();
			for (Integer w : lAdy[u]) {
				if (vis[w] == -1) {
					// no lo he visto sea lo que sea
					if (w >= personas) {
						// es un articulo
						vis[w] = vis[u];
						dq.addLast(w);
					} else {
						// es una persona
						vis[w] = vis[u] + 1;
						dq.addLast(w);
					}
				}
			}
		}
	}

}
