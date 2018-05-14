package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class ANodeToFar {
	static final int INF = Integer.MAX_VALUE / 3;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);

		int consul = 1;
		while (true) {
			int aristas = in.nextInt();
			if (aristas == 0)
				break;

			TreeMap<String, ArrayList<String>> map = new TreeMap<>();

			for (int i = 0; i < aristas; i++) {
				String x = in.next(), y = in.next();
				if (!map.containsKey(x)) {
					map.put(x, new ArrayList<>());
				}
				if (!map.containsKey(y)) {
					map.put(y, new ArrayList<>());
				}
				map.get(x).add(y);
				map.get(y).add(x);
			}

			while (true) {
				String node = in.next();
				int time = in.nextInt();
				if (node.equals("0") && time == 0)
					break;
				out.printf("Case %d: %d nodes not reachable from node %s with TTL = %d.%n", consul,
						bfs(map, node, time), node, time);
				consul++;
			}
		}

		out.close();
		in.close();
	}

	static int bfs(TreeMap<String, ArrayList<String>> map, String node, int time) {
		Queue<String> q = new LinkedList<>();
		TreeMap<String, Integer> solve = new TreeMap<>();
		for (Entry<String, ArrayList<String>> a : map.entrySet()) {
			solve.put(a.getKey(), INF);
		}

		q.add(node);
		solve.put(node, 0);
		while (!q.isEmpty()) {
			String u = q.poll();
			if (map.containsKey(u) && solve.get(u) < time) {
				ArrayList<String> ady = map.get(u);
				for (String w : ady) {
					if (solve.get(w) == INF) {
						solve.put(w, solve.get(u) + 1);
						q.add(w);
					}
				}
			}
		}

		int res = 0;
		for (Entry<String, Integer> a : solve.entrySet()) {
			if (a.getValue() == INF) {
				res += 1;
			}
		}
		return res;
	}
}
