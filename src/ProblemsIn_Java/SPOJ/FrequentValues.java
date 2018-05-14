package ProblemsIn_Java.SPOJ;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FrequentValues {
	static node Tree[];
	static int a[];
	static final int MAX = 1<<17;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int n, q, i, u, v;
		StringTokenizer st;
		String line = in.readLine().trim();
		while (!line.equals("0")) {

			st = new StringTokenizer(line);
			n = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());

			a = new int[n];
			st = new StringTokenizer(in.readLine());
			for (i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}

			Tree = new node[MAX<<1];
			for (i = 0; i < Tree.length; i++) {
				Tree[i]=new node();
			}
			init(1, 0, n - 1);
			for (i = 0; i <q; i++) {
				st = new StringTokenizer(in.readLine());
				u = Integer.parseInt(st.nextToken());
				v= Integer.parseInt(st.nextToken());
				if(u==v)out.println(1);
				else {
					out.println(query(1, 0, n-1, --u, --v));
				}
			}

			line = in.readLine();

		}

		out.close();
		in.close();
	}

	private static void init(int Node, int i, int j) {
		if (i == j) {
			Tree[Node].lfreq = Tree[Node].rfreq = Tree[Node].mfreq = 1;
			return;
		}
		int m = (i + j) >> 1;
		init(Node << 1, i, m);
		init((Node << 1) + 1, m + 1, j);
		if (a[m] == a[m + 1]) {
			Tree[Node].lfreq = Tree[Node << 1].lfreq + Tree[(Node << 1) + 1].lfreq * (a[i] == a[m] ? 1 : 0);
			Tree[Node].rfreq = Tree[(Node << 1) + 1].rfreq + Tree[Node << 1].rfreq * (a[j] == a[m + 1] ? 1 : 0);
			int temp = Tree[Node << 1].rfreq + Tree[(Node << 1) + 1].lfreq;
			Tree[Node].mfreq = Math.max(temp, Math.max(Tree[Node << 1].mfreq, Tree[(Node << 1) + 1].mfreq));
		} else {
			Tree[Node].lfreq = Tree[Node << 1].lfreq;
			Tree[Node].rfreq = Tree[(Node << 1) + 1].rfreq;
			Tree[Node].mfreq = Math.max(Tree[Node << 1].mfreq, Tree[(Node << 1) + 1].mfreq);
		}
	}

	static int query(int Node, int i, int j, int u, int v) {
		if (u == i && v == j)
			return Tree[Node].mfreq;
		int m = (i + j) >> 1;
		if (v <= m)
			return query(Node << 1, i, m, u, v);
		if (u > m)
			return query((Node << 1) + 1, m + 1, j, u, v);
		int leftv = query(Node << 1, i, m, u, m);
		int rightv = query((Node << 1) + 1, m + 1, j, m + 1, v);
		if (a[m] == a[m + 1]) {
			int temp = Math.min(Tree[Node << 1].rfreq, m - u + 1) + Math.min(Tree[(Node << 1) + 1].lfreq, v - m);
			return Math.max(temp, Math.max(rightv, leftv));
		} else
			return Math.max(leftv, rightv);
	}

	static class node {
		public int mfreq, lfreq, rfreq;
		public node() {
		}
	}

}
