package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class TheLargestClique {

	static LinkedList<Integer>[] G;
	static Stack<Integer> sort;
	static int mark;
	static int[] V;
	static int[] W;
	static int[] dp;
	static TreeSet<Integer>[] C;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);
		int tc = in.nextInt();
		while (tc-- > 0) {
			int nodes = in.nextInt();
			int edges = in.nextInt();
			G = new LinkedList[nodes];
			for (int i = 0; i < G.length; i++)
				G[i] = new LinkedList<Integer>();
			for (int i = 0; i < edges; i++) {
				G[in.nextInt() - 1].add(in.nextInt() - 1);
			}
			V = new int[nodes];
			sort = new Stack<Integer>();
			compress();
			out.println(longestPath());
		}
		out.close();
	}

	public static LinkedList<Integer>[] transpose() {
		LinkedList<Integer>[] Gt = new LinkedList[G.length];
		for (int i = 0; i < Gt.length; i++)
			Gt[i] = new LinkedList<Integer>();
		for (int i = 0; i < G.length; i++)
			for (int j : G[i])
				Gt[j].add(i);
		return Gt;
	}

	public static void dfs(int i, boolean push) {
		if (V[i] == -1) {
			V[i] = mark;
			for (int j : G[i])
				dfs(j, push);
			if (push)
				sort.push(i);
		}
	}

	public static void compress() {
		Arrays.fill(V, -1);
		mark = 0;
		for (int i = 0; i < G.length; i++)
			dfs(i, true);

		int SCC = 0;
		Arrays.fill(V, -1);
		G = transpose();
		while (!sort.isEmpty()) {
			int k = sort.pop();
			if (V[k] == -1) {
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
			count[V[i]]++;
			for (int j : G[i]) {
				if (V[i] != V[j])
					compressed[V[i]].add(V[j]);
			}
		}
		C = compressed;
		W = count;
	}

	public static int go(int i) {
		if (dp[i] != -1)
			return dp[i];
		int max = 0;
		for (int j : C[i])
			max = Math.max(max, go(j));
		return dp[i] = max + W[i];
	}

	public static int longestPath() {
		dp = new int[W.length];
		Arrays.fill(dp, -1);
		int max = 0;
		for (int i = 0; i < dp.length; i++)
			max = Math.max(max, go(i));
		return max;
	}
}
