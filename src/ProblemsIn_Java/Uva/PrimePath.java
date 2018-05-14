package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class PrimePath {

	static TreeSet<Integer> primes;
	static HashMap<Integer, ArrayList<Integer>> graph;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		// FileWriter out = new FileWriter(new File("debug.txt"));

		Criba_1();
		init();

		StringTokenizer st;
		int casos = Integer.parseInt(in.readLine());
		for (int i = 0; i < casos; i++) {
			st = new StringTokenizer(in.readLine());
			int source = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());

			out.println(bfs(source, target));

		}

		out.close();
		in.close();
	}

	static int bfs(int source, int target) {
		Queue<Integer> q = new LinkedList<Integer>();
		int visit[] = new int[10000];
		Arrays.fill(visit, -1);

		if (source == target)
			return 0;

		visit[source] = 0;
		q.add(source);
		while (!q.isEmpty()) {
			int u = q.poll();
			ArrayList<Integer> list = graph.get(u);
			for (Integer w : list) {
				if (visit[w] == -1 && w>999) {
					visit[w] = visit[u] + 1;
					if (w == target)
						return visit[w];
					q.add(w);
				}
			}
		}
		return visit[target];
	}

	static void init() {

		int primero, segundo, tercero, cuarto;

		graph = new HashMap<>();

		for (Integer prime : primes) {
			graph.put(prime, new ArrayList<>());

			int prime1 = prime;

			cuarto = prime1 % 10;

			prime1 = prime1 / 10;
			tercero = prime1 % 10;

			prime1 = prime1 / 10;
			segundo = prime1 % 10;

			prime1 = prime1 / 10;
			primero = prime1 % 10;

			// reemplaza el primero
			for (int i = 0; i < 10; i++) {
				int u = Integer.parseInt(i + "" + segundo + "" + tercero + "" + cuarto);
				if (u != prime && primes.contains(u)) {
					graph.get(prime).add(u);
				}
			}
			// reemplaza el segundo
			for (int i = 0; i < 10; i++) {
				int u = Integer.parseInt(primero + "" + i + "" + tercero + "" + cuarto);
				if (u != prime && primes.contains(u)) {
					graph.get(prime).add(u);
				}
			}
			// reemplaza el tercero
			for (int i = 0; i < 10; i++) {
				int u = Integer.parseInt(primero + "" + segundo + "" + i + "" + cuarto);
				if (u != prime && primes.contains(u)) {
					graph.get(prime).add(u);
				}
			}
			// reemplaza el cuarto
			for (int i = 0; i < 10; i++) {
				int u = Integer.parseInt(primero + "" + segundo + "" + tercero + "" + i);
				if (u != prime && primes.contains(u)) {
					graph.get(prime).add(u);
				}
			}
		}
	}

	public static void Criba_1() {
		int max = 10000;
		boolean b[] = new boolean[max];
		b[2] = true; // 2 es primo
		for (int i = 3; i < max; i += 2) {
			b[i] = true;
		}
		int I = (int) Math.sqrt(max) + 1;
		for (int i = 3; i <= I; i += 2) {
			if (b[i] == true) {
				for (int j = i * i, bi = 2 * i; j < max; j += bi) {
					b[j] = false;
				}
			}
		}
		primes = new TreeSet<>();
		primes.add(2);
		for (int i = 3; i < b.length; i++) {
			if (b[i]) {
				primes.add(i);
			}
		}
		// System.out.println(primes.size());
	}

}
