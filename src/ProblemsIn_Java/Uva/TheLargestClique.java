package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class TheLargestClique {

	static ArrayList<Integer>[] G;
	static Stack<Integer> sort;
	static int mark;
	static int[] vertex;
	static int[] weith;
	static int[] dp;
	static TreeSet<Integer>[] components;

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);
		int tc = in.nextInt();
		while (tc-- > 0) {
			int nodes = in.nextInt();
			int edges = in.nextInt();
			G = new ArrayList[nodes];
			for (int i = 0; i < G.length; i++)
				G[i] = new ArrayList<>();
			for (int i = 0; i < edges; i++) {
				G[in.nextInt() - 1].add(in.nextInt() - 1);
			}
			vertex = new int[nodes];
			sort = new Stack<Integer>();
			compress();
			out.println(longestPath());
		}
		out.close();
	}

	public static ArrayList<Integer>[] transpose() {
		ArrayList<Integer>[] Gt = new ArrayList[G.length];
		for (int i = 0; i < Gt.length; i++)
			Gt[i] = new ArrayList<Integer>();
		for (int i = 0; i < G.length; i++)
			for (int j : G[i])
				Gt[j].add(i);
		return Gt;
	}

	public static void dfs(int i, boolean push) {
		if (vertex[i] == -1) {
			vertex[i] = mark;
			for (int j : G[i])
				dfs(j, push);
			if (push)
				sort.push(i);
		}
	}

	public static void compress() {
		Arrays.fill(vertex, -1);
		mark = 0;
		for (int i = 0; i < G.length; i++)
			dfs(i, true);

		int SCC = 0;
		Arrays.fill(vertex, -1);
		G = transpose();
		while (!sort.isEmpty()) {
			int k = sort.pop();
			if (vertex[k] == -1) {
				mark = SCC;
				dfs(k, false);
				SCC++;
			}
		}
		G = transpose();
		TreeSet<Integer>[] compressed = new TreeSet[SCC];
		int[] count = new int[SCC];
		for (int i = 0; i < SCC; i++)
			compressed[i] = new TreeSet<Integer>();
		for (int i = 0; i < G.length; i++) {
			count[vertex[i]]++;
			for (int j : G[i]) {
				if (vertex[i] != vertex[j])
					compressed[vertex[i]].add(vertex[j]);
			}
		}
		components = compressed;
		weith = count;
	}

	public static int go(int i) {
		if (dp[i] != -1)
			return dp[i];
		int max = 0;
		for (int j : components[i])
			max = Math.max(max, go(j));
		return dp[i] = max + weith[i];
	}

	public static int longestPath() {
		dp = new int[weith.length];
		Arrays.fill(dp, -1);
		int max = 0;
		for (int i = 0; i < dp.length; i++)
			max = Math.max(max, go(i));
		return max;
	}
}
