package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Oreon {
	public static double mAdy[][];
	public static char a = 'A';
	public static ArrayList<edge> lAdy[];

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int casos = Integer.parseInt(in.readLine().trim()), tam, peso;
		StringTokenizer st;

		for (int k = 1; k <= casos; k++) {
			out.printf("Case %d:%n", k);
			tam = Integer.parseInt(in.readLine().trim());
			mAdy = new double[tam][tam];
			lAdy = new ArrayList[tam];

			for (int i = 0; i < mAdy.length; i++) {
				st = new StringTokenizer(in.readLine(), ", ");
				lAdy[i] = new ArrayList<>();
				for (int j = 0; j < mAdy[i].length; j++) {
					peso = Integer.parseInt(st.nextToken());
					if (peso != 0) {
						lAdy[i].add(new edge(i, j, peso));
					}
					mAdy[i][j] = peso;
				}
			}
			boolean res[][] = primPQ();
			ArrayList<pareja> r = new ArrayList<>();
			for (int i = 0; i < res.length; i++) {
				for (int j = 0; j < res.length; j++) {
					if (res[i][j] && i != j) {
						char u = (char) (a + i), v = (char) (a + j);
						double p = mAdy[i][j];
						pareja n = new pareja(u, v, p);
						r.add(n);
					}
				}
			}
			Collections.sort(r);
			for (int i = 0; i < r.size(); i += 2) {
				pareja n = r.get(i);
				out.println(n);
			}

		}
		out.close();
		in.close();

	}

	static boolean[][] primPQ() {
		boolean visit[] = new boolean[lAdy.length];
		PriorityQueue<edge> pq = new PriorityQueue<>();
		boolean res[][] = new boolean[lAdy.length][lAdy.length];
		pq.addAll(lAdy[0]);
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

	static class pareja implements Comparable<pareja> {
		char a, b;
		double peso;

		public pareja(char a, char b, double peso) {
			if (b > a) {
				this.a = a;
				this.b = b;
			} else {
				this.a = b;
				this.b = a;
			}
			this.peso = peso;
		}

		@Override
		public int compareTo(pareja o) {
			if (this.peso > o.peso) {
				return 1;
			} else if (this.peso < o.peso) {
				return -1;
			} else if (this.a > o.a) {
				return 1;
			} else if (this.a < o.a) {
				return -1;
			} else if (this.b > o.b) {
				return 1;
			} else if (this.b < o.b) {
				return -1;
			}
			return 0;
		}

		@Override
		public String toString() {
			return String.format("%s-%s %d", a, b, (int) peso);
		}
	}

}
