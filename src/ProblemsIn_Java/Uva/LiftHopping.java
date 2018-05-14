package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class LiftHopping {

	public static long solve[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (String line; (line = in.readLine()) != null;) {
			st = new StringTokenizer(line);
			int asensores = Integer.parseInt(st.nextToken());
			int objetivo = Integer.parseInt(st.nextToken());

			int costos[] = new int[asensores];
			st = new StringTokenizer(in.readLine());
			int cont = 0;
			while (st.hasMoreTokens()) {
				costos[cont] = Integer.parseInt(st.nextToken());
				cont++;
			}

			// m x n + 2 siendo m: asensores n: pisos
			long mAdy[][] = new long[asensores * 100 + 2][asensores * 100 + 2];

			for (long[] ls : mAdy) {
				Arrays.fill(ls, -1);
			}

			ArrayList<Integer> ady[] = new ArrayList[asensores];
			for (int i = 0; i < ady.length; i++) {
				st = new StringTokenizer(in.readLine());
				ady[i] = new ArrayList<>();
				while (st.hasMoreTokens()) {
					ady[i].add(Integer.parseInt(st.nextToken()));
				}
			}

			// determinar nodos : 100 * asensor + piso

			for (int i = 0; i < ady.length; i++) {
				for (int j = 0; j < ady[i].size(); j++) {
					int nodo1 = calcular(i, ady[i].get(j)); // nodo actual
					for (int k = j + 1; k < ady[i].size(); k++) {
						int nodo2 = calcular(i, ady[i].get(k));
						mAdy[nodo1][nodo2] = mAdy[nodo2][nodo1] = (ady[i].get(k) - ady[i].get(j)) * costos[i];
					}
				}
			}

			for (int i = ady.length - 1; i >= 0; i--) {
				for (int j = i - 1; j >= 0; j--) {
					for (int k = 0; k < ady[j].size(); k++) {
						// cambio de ascensor mismo piso
						if (ady[i].contains(ady[j].get(k))) {
							int nodo1 = calcular(i, ady[j].get(k));
							int nodo2 = calcular(j, ady[j].get(k));
							mAdy[nodo1][nodo2] = mAdy[nodo2][nodo1] = 60;
						}
					}
				}
			}

			for (int i = 0; i < ady.length; i++) {
				for (int j = 0; j < ady[i].size(); j++) {
					// super entrada
					if (ady[i].get(j) == 0) {
						int nodo1 = calcular(i, ady[i].get(j));
						int nodo2 = mAdy.length - 2;
						mAdy[nodo1][nodo2] = mAdy[nodo2][nodo1] = 0;
					}
					// super salida
					if (ady[i].get(j) == objetivo) {
						int nodo1 = calcular(i, ady[i].get(j));
						int nodo2 = mAdy.length - 1;
						mAdy[nodo1][nodo2] = mAdy[nodo2][nodo1] = 0;
					}
				}
			}

			solve = new long[mAdy.length];
			Arrays.fill(solve, Long.MAX_VALUE);
			
			dijkstra(mAdy);
			
			if (objetivo == 0) {
				out.println(0);
			} else if (solve[mAdy.length-1] != Long.MAX_VALUE) {
				out.println(solve[mAdy.length-1]);
			} else {
				out.println("IMPOSSIBLE");
			}
		}

		out.close();
		in.close();
	}

	public static void dijkstra(long mAdy[][]) {  //Complejidad  grafo denso: n*n*log n  grafo disperso: n log n
		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.add(mAdy.length - 2);
		solve[mAdy.length - 2] = 0;
		while (!q.isEmpty()) {
			int u = q.poll();
			for (int i = 0; i < mAdy.length; i++) {
				if (mAdy[u][i] != -1 && (mAdy[u][i] + solve[u]) < solve[i]) {
					solve[i] = mAdy[u][i] + solve[u];
					q.add(i);
				}
			}
		}

	}

	public static int calcular(int p, int a) {
		int m = 100;
		return p * m + a;
	}
}
