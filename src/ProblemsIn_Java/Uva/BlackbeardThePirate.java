package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 *
 * @number 10937
 * @Problema: Este problema requiere hallar un camino de costo minimo donde el
 *            camino pasa por todos los nodos y vuelve al origen sin embargo
 *            como se trabaja sobre una matriz de char solo lo que se hace es
 *            volver el grafo que no lo dan de esta forma a volverlo a una
 *            matriz de adyacencias de costo de tama�o n siendo n los nodos;
 *            este problema se puede solucionar primero generandoi esta matriz
 *            de adayacencia de tama�ano n despues de esto hay 3 procedimientos
 *            posibles.Uno de ellos es generar todas las permutaciones posibles
 *            y mirar cual es la mas barata esta solucion sale en un tiempo de
 *            0.520 segundos.Otra de ellos es tratar el problema como un
 *            problema de programaci�n dinamica y el tiempod e esta solucion es
 *            0.100 segundos.
 *
 *            Uno de ellos y la maas efectiva es usar el algoritmo de tsp que
 *            esta en la ancheta y su tiempo fue de 0.050 segundos.
 *
 */
public class BlackbeardThePirate {
	static int h, w;
	static final int INF = Integer.MAX_VALUE / 2;
	static final int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[][] mAdy_2;
	static char[][] mAdy;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		for (String line; !(line = in.readLine().trim()).equals("0 0");) {
			st = new StringTokenizer(line);
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			mAdy = new char[h + 2][w + 2];
			Arrays.fill(mAdy[0], '#');
			Arrays.fill(mAdy[h + 1], '#');
			for (int i = 1; i <= h; i++) {
				mAdy[i][0] = '#';
				System.arraycopy(in.readLine().trim().toCharArray(), 0, mAdy[i], 1, w);
				mAdy[i][w + 1] = '#';
			}
			boolean isPossible = true;
			ArrayList<int[]> vertices = new ArrayList<>();
			Ciclo: for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					if (mAdy[i][j] == '!' || mAdy[i][j] == '@') {
						vertices.add(new int[] { i, j });
						mAdy[i][j] = '!';
					} else if (mAdy[i][j] == '*') {
						for (int H = i - 1; H < i + 2; H++) {
							for (int W = j - 1; W < j + 2; W++) {
								if (mAdy[H][W] == '.')
									mAdy[H][W] = '#';
								if (mAdy[H][W] == '!' || mAdy[H][W] == '@') {
									isPossible = false;
									break Ciclo;
								}
							}
						}
					}
				}
			}
			mAdy_2 = isPossible ? BuildGraph(vertices) : null;
			if (mAdy_2 == null)
				System.out.println("-1");
			else {
				boolean a[] = new boolean[vertices.size()];
				a[0] = true;
				/*
				 * boolean b [] = new boolean[vertices.size()]; int x [] = new
				 * int[vertices.size()]; System.out.println(permutation(, b,
				 * 1)); System.out.println(f(vertices.size()));
				 */
				int res = (int) tsp(mAdy_2, 0);
				System.out.println(res == 2147483647 ? -1 : res);
			}
		}

		in.close();
	}

	static int memo[][][];

	static int f(int n) {
		memo = new int[1 << n][n][n];
		for (int i = 0; i < memo.length; i++) {
			for (int j = 0; j < n; j++) {
				Arrays.fill(memo[i][j], -1);
			}
		}
		return g((1 << n) - 1, 0, 0);
	}

	static int g(int set, int u, int v) {
		if (memo[set][u][v] != -1)
			return memo[set][u][v];
		if ((set & (1 << u)) == 0 || (set & (1 << v)) == 0) {
			return INF;
		} else if (u == v && Integer.bitCount(set) == 1) {
			return 0;
		}
		int minCost = INF;
		for (int x = 0; x < 11; x++) {
			for (int y = 0; y < 11; y++) {
				if ((set & (1 << x)) != 0 && (set & (1 << y)) != 0) {
					int newSet = set & (~(1 << v));
					int cost = g(newSet, x, y);
					if (cost == INF) {
						minCost = Math.min(minCost, cost + mAdy_2[u][x] + mAdy_2[y][v]);
					}
				}
			}
		}
		return memo[set][u][v] = minCost;
	}

	static int permutation(int[] vector, boolean[] used, int source) {
		int n = vector.length;
		if (source == n) {
			int cost = 0;
			for (int i = 1; i < n; i++) {
				cost += mAdy_2[vector[i]][vector[i - 1]];
			}
			return cost + mAdy_2[vector[0]][vector[1]];
		} else {
			int cost = INF;
			for (int i = 0; i < n; i++) {
				if (!used[i]) {
					vector[source] = i;
					used[i] = true;
					cost = Math.min(cost, permutation(vector, used, source + 1));
					used[i] = false;
				}
			}
			return cost;
		}
	}

	/**
	 * @param vertices11
	 * @return
	 */
	private static int[][] BuildGraph(ArrayList<int[]> vertices) {
		int n = vertices.size();
		int[][] mAdj = new int[n][n];
		for (int i = 0; i < n - 1; i++) {
			int[][] cost = new int[h + 2][w + 2];
			for (int[] js : cost) {
				Arrays.fill(js, INF);
			}
			int[] source = vertices.get(i);
			cost[source[0]][source[1]] = 0;
			ArrayDeque<int[]> q = new ArrayDeque<>();
			q.addFirst(source);
			while (!q.isEmpty()) {
				int[] u = q.pollFirst();
				for (int[] js : dirs) {
					int r = u[0] + js[0];
					int c = u[1] + js[1];
					if ((mAdy[r][c] == '.' || mAdy[r][c] == '!') && (cost[r][c] == INF)) {
						q.addLast(new int[] { r, c });
						cost[r][c] = cost[u[0]][u[1]] + 1;
					}
				}
			}
			for (int j = 0; j < n; j++) {
				if (j != i) {
					int[] u = vertices.get(j);
					mAdj[i][j] = mAdj[j][i] = cost[u[0]][u[1]];
					// return null;
				}
			}
		}

		return mAdj;
	}

	static double tsp(int[][] mAdy, int v) {
		int n = mAdy.length, t = 1 << n;
		double mem[][] = new double[t][n];
		for (double[] arr : mem)
			Arrays.fill(arr, -1d);
		return tsp(mAdy, n, v, v, 1 << v, mem);
	}

	static double tsp(int[][] mAdy, int n, int v1, int v2, int visitados, double[][] mem) {
		if (mem[visitados][v1] >= 0d)
			return mem[visitados][v1];
		if (visitados == (1 << n) - 1)
			return mem[visitados][v1] = mAdy[v1][v2];
		double min = Double.POSITIVE_INFINITY, d;
		for (int e = visitados, j = 0; j < n; j++, e >>>= 1)
			if ((e & 1) == 0 && (d = mAdy[v1][j]) < min)
				min = Math.min(min, d + tsp(mAdy, n, j, v2, visitados | (1 << j), mem));
		return mem[visitados][v1] = min;
	}
}
