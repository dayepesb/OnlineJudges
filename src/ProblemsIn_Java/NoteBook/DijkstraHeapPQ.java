package ProblemsIn_Java.NoteBook;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DijkstraHeapPQ {

	static double[] heapCost;
	static int[] heapIndex;
	static int heapSize;
	static int[] lookup;

	static double[] d;
	static int[] pi;

	static int M;
	static int K;
	static int[] T;
	static int NF = 100;

	static int N;

	static LinkedList<Integer>[] adj;
	static LinkedList<Double>[] w;

	static void initHeap() {
		heapCost = new double[N];
		Arrays.fill(heapCost, Double.POSITIVE_INFINITY);
		heapIndex = new int[N];
		for (int i = 0; i < N; i++)
			heapIndex[i] = i;
		lookup = new int[N];
		for (int i = 0; i < N; i++)
			lookup[i] = i;
		heapSize = N;
	}

	static int remove() {
		int next = heapIndex[0];
		heapSize--;
		heapCost[0] = heapCost[heapSize];
		heapIndex[0] = heapIndex[heapSize];
		lookup[heapIndex[0]] = 0;
		int cur = 0, left = 1, right = 2, min = cur, temp;
		double temp2;
		while (left < heapSize) {
			if (heapCost[cur] > heapCost[left])
				min = left;
			if (right < heapSize && heapCost[min] > heapCost[right])
				min = right;
			if (min == cur)
				break;
			temp = heapIndex[cur];
			heapIndex[cur] = heapIndex[min];
			heapIndex[min] = temp;
			temp2 = heapCost[cur];
			heapCost[cur] = heapCost[min];
			heapCost[min] = temp2;
			lookup[heapIndex[cur]] = cur;
			lookup[heapIndex[min]] = min;
			cur = min;
			left = cur * 2 + 1;
			right = cur * 2 + 2;
		}
		lookup[next] = -1;
		return next;
	}

	static void update(int u, double cost) {
		heapCost[lookup[u]] = cost;
		d[u] = cost;
		int cur = lookup[u], par = (cur - 1) / 2, temp;
		double temp2;
		while (cur > 0 && heapCost[par] > heapCost[cur]) {
			temp = heapIndex[cur];
			heapIndex[cur] = heapIndex[par];
			heapIndex[par] = temp;
			temp2 = heapCost[cur];
			heapCost[cur] = heapCost[par];
			heapCost[par] = temp2;
			lookup[heapIndex[cur]] = cur;
			lookup[heapIndex[par]] = par;
			cur = par;
			par = (cur - 1) / 2;
		}
	}

	static void init() {
		d = new double[N];
		Arrays.fill(d, Double.POSITIVE_INFINITY);
		pi = new int[N];
		Arrays.fill(pi, -1);
		adj = new LinkedList[N];
		for (int i = 0; i < N; i++)
			adj[i] = new LinkedList<Integer>();
		w = new LinkedList[N];
		for (int i = 0; i < N; i++)
			w[i] = new LinkedList<Double>();
	}

	static void dijkstra(int s) {
		initHeap();
		update(s, 0);
		while (heapSize > 0) {
			int u = remove();
			for (int i = 0; i < adj[u].size(); i++) {
				int v = adj[u].get(i);
				double c = w[u].get(i);
				if (d[v] > d[u] + c) {
					pi[v] = u;
					update(v, d[u] + c);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("lift.in"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String ln = in.readLine();
		StringTokenizer st;
		while (ln != null && !ln.trim().equals("")) {
			st = new StringTokenizer(ln);
			M = Integer.parseInt(st.nextToken());
			N = NF * M + 2;
			K = Integer.parseInt(st.nextToken());
			init();
			T = new int[M];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < M; i++)
				T[i] = Integer.parseInt(st.nextToken());
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(in.readLine());
				int[] F = new int[st.countTokens()];
				for (int i = 0; i < F.length; i++)
					F[i] = Integer.parseInt(st.nextToken());
				Arrays.sort(F);
				for (int i = 0; i < F.length; i++) {
					for (int j = i + 1; j < F.length; j++) {
						double c = (F[j] - F[i]) * T[m];
						adj[F[i] * M + m].add(F[j] * M + m);
						w[F[i] * M + m].add(c);
						adj[F[j] * M + m].add(F[i] * M + m);
						w[F[j] * M + m].add(c);
					}
				}
			}
			for (int f = 0; f < NF; f++) {
				for (int i = 0; i < M; i++) {
					for (int j = i + 1; j < M; j++) {
						adj[f * M + i].add(f * M + j);
						w[f * M + i].add(60d);
						adj[f * M + j].add(f * M + i);
						w[f * M + j].add(60d);
					}
				}
			}
			for (int i = 0; i < M; i++) {
				adj[N - 2].add(i);
				w[N - 2].add(0d);
			}
			for (int i = 0; i < M; i++) {
				adj[K * M + i].add(N - 1);
				w[K * M + i].add(0d);
			}
			dijkstra(N - 2);
			if (Double.isInfinite(d[N - 1]))
				System.out.printf("IMPOSSIBLE\n");
			else
				System.out.printf("%.0f\n", d[N - 1]);
			ln = in.readLine();
		}

	}

}
