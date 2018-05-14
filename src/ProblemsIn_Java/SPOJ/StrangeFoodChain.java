package ProblemsIn_Java.SPOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StrangeFoodChain {
	static int root[],d[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int h = Integer.parseInt(in.readLine().trim());
		for (int c = 1; c <= h; c++) {
			int n, k;
			StringTokenizer st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			root = new int[n + 1];
			d = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				root[i] = i;
				d[i] = 0;
			}
			int ans = 0;
			while (k-- > 0) {
				int x, y, t;
				st = new StringTokenizer(in.readLine());
				t = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				int px, py, tmp, i;
				if (x > n || y > n) {
					ans++;
					continue;
				}
				px = find(x);
				py = find(y);
				t--;
				if (px == py) {
					tmp = (d[x] - d[y]) % 3;
					if (tmp < 0)
						tmp += 3;
					if (tmp != t)
						ans++;
				} else {
					root[px] = py;
					i = (d[x] - d[y] - t) % 3;
					d[px] = i < 0 ? -i : -i + 3;
				}
			}
			out.printf("%d\n", ans);
		}

		out.close();
		in.close();
	}

	/*
	 * Busca el padre o nodo raiz en este arbol
	 */
	static int find(int u) {
		if (u == root[u])
			return u;
		int tmp = root[u];
		root[u] = find(root[u]);
		d[u] = d[tmp] + d[u];
		return root[u];
	}

}
