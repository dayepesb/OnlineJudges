package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author David Yepes Buitrago
 *
 * @Date 27-07-2017
 */
public class TheBottomOfAGraph {
	static ArrayList<Integer> ady[];
	static int low[], dfs[];
	static boolean inSt[];
	static int index = 0;
	static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int n, e, i, j, k;
		for (String line; !(line = in.readLine().trim()).equals("0");) {
			st = new StringTokenizer(line);
			n = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			ady = new ArrayList[n + 1];
			for (int l = 0; l < n + 1; ady[l] = new ArrayList<>(), l++)
				;
			st = new StringTokenizer(in.readLine());
			for (i = 0; i < e; i++) {
				j = Integer.parseInt(st.nextToken());
				k = Integer.parseInt(st.nextToken());
				ady[j].add(k);
			}
			tarjan(n);
			for (i = 0; i <= n; i++)
				inSt[i] = true;
			for (i = 1; i <= n; i++) {
				for (j = 0; j < ady[i].size(); j++) {
					if (low[i] != low[ady[i].get(j)]) {
						inSt[low[i]] = false;
						break;
					}
				}
			}
			for (i = 1; i <= n; i++) {
				if (inSt[low[i]])
					out.printf("%d ", i);
			}
			out.printf("\n");
		}

		in.close();
		out.close();
	}

	/**
	 * @param n
	 */
	static void tarjan(int n) {
		index = 0;
		stack = new Stack<>();
		low = new int[n + 1];
		dfs = new int[n + 1];
		inSt = new boolean[n + 1];
		Arrays.fill(low, -1);
		Arrays.fill(dfs, -1);
		Arrays.fill(inSt, false);
		for (int i = 1; i <= n; i++) {
			if (dfs[i] == -1) {
				strConnect(i);
			}
		}
	}

	/**
	 * @param i
	 */
	static void strConnect(int v) {
		low[v] = dfs[v] = index++;
		stack.push(v);
		inSt[v] = true;
		for (int i = 0; i < ady[v].size(); i++) {
			if (dfs[ady[v].get(i)] == -1) {
				strConnect(ady[v].get(i));
				low[v] = Math.min(low[v], low[ady[v].get(i)]);
			} else if (inSt[ady[v].get(i)]) {
				low[v] = Math.min(low[v], dfs[ady[v].get(i)]);
			}
		}
		if (low[v] == dfs[v]) {
			while (!stack.empty()) {
				int temp = stack.pop();
				inSt[temp] = false;
				low[temp] = dfs[v];
				if (temp == v)
					break;
			}
		}
	}
}
