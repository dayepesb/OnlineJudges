package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 *
 */
public class TourBelt {
	static int A[][], B[][];
	static int P[], C[];
	static Edge E[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int nodos, aristas, u, v, w;

		for (int c = Integer.parseInt(in.readLine().trim()); c > 0; c--) {
			st = new StringTokenizer(in.readLine());
			nodos = Integer.parseInt(st.nextToken());
			aristas = Integer.parseInt(st.nextToken());

			A = new int[nodos + 1][nodos + 1];
			B = new int[nodos + 1][nodos + 1];
			P = new int[nodos + 1];
			C = new int[nodos + 1];
			E = new Edge[aristas];

			for (int i = 1; i <= nodos; i++) {
				P[i] = i;
				C[i] = 1;

				for (int j = 1; j <= nodos; j++) {
					A[i][j] = 1 << 29;
					B[i][j] = 0;
				}
			}

			for (int i = 0; i < aristas; i++) {
				st = new StringTokenizer(in.readLine());
				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				w = Integer.parseInt(st.nextToken());

				E[i] = new Edge(u, v, w);

				A[u][v] = A[v][u] = B[u][v] = B[v][u] = w;
			}

			Arrays.sort(E);

			int total = 0;
			for (int i = 0; i < aristas; i++) {
				int xx = E[i].x;
				int yy = E[i].y;
				int x = findset(xx), y = findset(yy);
				if (x == y) {
					continue;
				} else {

					int a = unionset(x, y);

					int outside = 0, inside = 1 << 29;
					for (int j = 1; j <= nodos; j++) {
						A[a][j] = A[j][a] = Math.min(A[x][j], A[y][j]);
						B[a][j] = B[j][a] = Math.max(B[x][j], B[y][j]);

						if (findset(a) == findset(j)) {
							inside = Math.min(inside, A[a][j]);
						} else {
							outside = Math.max(outside, B[a][j]);
						}
					}

					if (inside > outside) {
						total += C[a];
					}
				}
			}

			out.println(total);

		}

		in.close();
		out.close();
	}

	static class Edge implements Comparable<Edge> {
		int x, y, v;

		Edge(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}

		@Override
		public int compareTo(Edge o) {
			if(this.v>o.v)return -1;
			else if(this.v<o.v)return 1;
			else return 0;
		}
	}

	static int findset(int v) {
		if (P[v] != v)
			return P[v] = findset(P[v]);
		return v;
	}

	static int unionset(int x, int y) {
		int a = findset(x), b = findset(y);
		if (a == b)
			return 0;
		if (a > b) {
			int c = a;
			a = b;
			b = c;
		}
		P[b] = a;
		C[a] += C[b];
		C[b] = 0;
		return a;
	}
}
