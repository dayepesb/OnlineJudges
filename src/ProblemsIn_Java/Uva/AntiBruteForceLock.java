package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class AntiBruteForceLock {

	static ArrayList<edge> lAdy[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int casos = Integer.parseInt(in.readLine().trim());
		for (int k = 0; k < casos; k++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			st.nextToken();
			int n = st.countTokens();
			int[] nodos = new int[n];
			int mAdy[][]=new int[n][n];
			for (int i = 0; i < n; i++) {
				nodos[i] = Integer.parseInt(st.nextToken());
			}
			lAdy = new ArrayList[n];
			for (int i = 0; i < n; lAdy[i] = new ArrayList<>(), i++)
				;

			int nodoIni = -1;
			int pesoIni = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				int pesoAux = pesoTo(0000, nodos[i]);
				if (pesoIni > pesoAux) {
					pesoIni = pesoAux;
					nodoIni = i;
				}
				for (int j = i + 1; j < n; j++) {
					int peso = pesoTo(nodos[i], nodos[j]);
					lAdy[i].add(new edge(i, j, peso));
					lAdy[j].add(new edge(j, i, peso));
					mAdy[i][j]=mAdy[j][i]=peso;
				}
			}

			boolean res [][] = primPQ(nodoIni);
			int sum = 0;
			for (int i = 0; i < res.length; i++) {
				for (int j = i+1; j < res.length; j++) {
					if(res[i][j])sum+=mAdy[i][j];
				}
			}
			out.println(sum+pesoIni);
			

		}

		out.close();
		in.close();
	}

	static int pesoTo(int a, int b) {
		int sum = 0, num1, num2;

		for (int i = 0; i < 4; i++) {
			num1 = a % 10;
			a = a / 10;

			num2 = b % 10;
			b = b / 10;

			sum += peso(num1, num2);
		}

		return sum;
	}

	static int peso(int a, int b) {
		if (a > b) {
			return Math.min(a - b, b + 10 - a);
		} else if (b > a) {
			return Math.min(b - a, a + 10 - b);
		}
		return 0;
	}

	static boolean[][] primPQ(int nodo) {
		boolean visit[] = new boolean[lAdy.length];
		PriorityQueue<edge> pq = new PriorityQueue<>();
		boolean res[][] = new boolean[lAdy.length][lAdy.length];
		pq.addAll(lAdy[nodo]);
		while (!pq.isEmpty()) {
			edge v = pq.poll();
			if (!visit[v.end]) {
				visit[v.start] = true;
				visit[v.end] = true;
				res[v.start][v.end] = res[v.end][v.start] = true;
				pq.addAll(lAdy[v.end]);
			}
		}
		return res;
	}

	static class edge implements Comparable<edge> {
		int start, end, with;

		public edge(int start, int end, int with) {
			this.start = start;
			this.end = end;
			this.with = with;
		}

		@Override
		public int compareTo(edge b) {
			return Integer.compare(this.with, b.with);
		}

		@Override
		public String toString() {
			return (this.start) + "," + (this.end) + "," + this.with;
		}
	}

}
