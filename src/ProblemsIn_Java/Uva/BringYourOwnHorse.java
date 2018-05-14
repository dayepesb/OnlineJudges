package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BringYourOwnHorse {
	static int nodes, edges;
	static ArrayList<edge>[] lAdy, prim;
	static int mAdy[][];
	static boolean[] vis;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int cases = Integer.parseInt(in.readLine().trim());
		for (int c = 0; c < cases; c++) {
			out.printf("Case %d%n", (c + 1));
			st = new StringTokenizer(in.readLine());
			nodes = Integer.parseInt(st.nextToken());
			edges = Integer.parseInt(st.nextToken());

			lAdy = new ArrayList[nodes];
			for (int i = 0; i < nodes; i++) {
				lAdy[i] = new ArrayList<>();
			}

			for (int i = 0; i < edges; i++) {
				st = new StringTokenizer(in.readLine());
				int start = Integer.parseInt(st.nextToken()) - 1;
				int end = Integer.parseInt(st.nextToken()) - 1;
				int weigth = Integer.parseInt(st.nextToken());

				lAdy[start].add(new edge(start, end, weigth));
				lAdy[end].add(new edge(end, start, weigth));
			}

			prim = primPQ();
			int q = Integer.parseInt(in.readLine().trim());
			mAdy = new int[nodes][nodes];
			for (int i = 0; i < q; i++) {
				st = new StringTokenizer(in.readLine());
				int start = Integer.parseInt(st.nextToken()) - 1;
				int end = Integer.parseInt(st.nextToken()) - 1;
				if (mAdy[start][end] == 0) {
					vis = new boolean[nodes];
					dfs(start, start, end, -1);
				}
				out.println(mAdy[start][end]);

			}
			out.println();
		}

		out.close();
		in.close();
	}

	private static void dfs(int i, int start, int end, int max) {
		mAdy[i][i] = 0;
		vis[i] = true;
		for (edge w : prim[i]) {
			if (!vis[w.end]) {
				int maxW = max;
				if (maxW < w.weigth) {
					maxW = w.weigth;
				}
				if (w.end == end) {
					mAdy[start][end] = mAdy[end][start] = Math.max(maxW, w.weigth);
					return;
				} else {
					mAdy[start][w.end] = mAdy[w.end][start] = Math.max(maxW, w.weigth);
					mAdy[i][w.end] = mAdy[w.end][i] = w.weigth;
					dfs(w.end, start, end, maxW);
				}
			}
		}
	}

	public static ArrayList<edge>[] primPQ() {
		boolean visit[] = new boolean[lAdy.length];
		PriorityQueue<edge> pq = new PriorityQueue<>();
		ArrayList<edge> res[] = new ArrayList[lAdy.length];
		for (int i = 0; i < nodes; i++) {
			res[i] = new ArrayList<>();
		}
		pq.addAll(lAdy[0]);
		while (!pq.isEmpty()) {
			edge v = pq.poll();
			if (!visit[v.end]) {
				visit[v.start] = true;
				visit[v.end] = true;
				res[v.start].add(new edge(v.start, v.end, v.weigth));
				res[v.end].add(new edge(v.end, v.start, v.weigth));
				pq.addAll(lAdy[v.end]);
			}
		}
		return res;
	}

	static class edge implements Comparable<edge> {
		int start, end, weigth;

		public edge(int start, int end, int weigth) {
			this.start = start;
			this.end = end;
			this.weigth = weigth;
		}

		@Override
		public int compareTo(edge o) {
			return Integer.compare(this.weigth, o.weigth);
		}

		@Override
		public String toString() {
			return (start + 1) + " " + (end + 1) + " " + weigth;
		}
	}

}
