package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class XPLosives {
	static int set[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		for (String line; (line = in.readLine()) != null;) {
			while (true) {
				if (line.trim().equals(""))
					line = in.readLine();
				else {
					break;
				}
			}

			set = new int[100100];
			Arrays.fill(set, -1);
			int res = 0;
			st = new StringTokenizer(line);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
			while (!(line = in.readLine().trim()).equals("-1")) {
				st = new StringTokenizer(line);
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				if (find(a) == find(b)) {
					res++;
				} else {
					union(a, b);
				}
			}
			out.println(res);
		}

		out.close();
		in.close();
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return;

		int sizex = -(set[x]);
		int sizey = -(set[y]);

		if (sizex < sizey) {
			set[y] = set[y] + set[x];
			set[x] = y;
		} else {
			set[x] = set[x] + set[y];
			set[y] = x;
		}

	}

	/*
	 * Busca el padre o nodo raiz en este arbol
	 */
	static int find(int x) {
		if (set[x] < 0)
			return x;
		else
			return set[x] = find(set[x]);
	}
}
