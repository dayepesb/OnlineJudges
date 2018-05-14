package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 25-02-2018
 * @time 0.000 ms
 */
public class Disjointwatersupply {
	static int set[], weith[], n, m, x, y;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		for (String line; (line = in.readLine()) != null;) {
			st = new StringTokenizer(line);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			set = new int[n + 1];
			weith = new int[n + 1];
			graph = new ArrayList[n + 1];
			for (int i = 0; i <= n; graph[i] = new ArrayList(), i++)
				;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				if (x == 1)
					set[y] = y;
				else
					graph[y].add(x);
			}

			for (int i = 2; i <= n; i++) {
				for (int j = 0; j < graph[i].size(); j++) {
					if (set[i] == 0)
						set[i] = graph[i].get(j);
					else if (findUnionFind(i) != findUnionFind(graph[i].get(j)))
						set[i] = i;
				}
			}

			System.out.println(Arrays.toString(set));
			for (int i = 2; i <= n; i++) {
				weith[findUnionFind(i)]++;
			}
			int ret = 0;
			for (int i = 2; i <= n; i++) {
				if (i == set[i]) {
					ret += weith[i] * (n - 1 - weith[i]);
				}
			}
			out.println(ret / 2 + n - 1);
		}

		in.close();
		out.close();
	}

	static int findUnionFind(int x) {
		return set[x] == x ? x : (set[x] = findUnionFind(set[x]));
	}
}
