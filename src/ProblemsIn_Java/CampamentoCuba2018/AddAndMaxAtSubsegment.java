package ProblemsIn_Java.CampamentoCuba2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AddAndMaxAtSubsegment {
	public static void main(String args[]) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int n = Integer.parseInt(in.readLine());
		long arr[] = new long[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		LazySegmentTree tree = new LazySegmentTree();
		tree.constructST(arr, n);
		int q = Integer.parseInt(in.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while (q-- > 0) {
			st = new StringTokenizer(in.readLine());
			switch (st.nextToken()) {
			case "m":
				sb.append(tree.getSum(n, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1));
				sb.append(" ");
				break;
			case "a":
				tree.updateRange(n, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
						Integer.parseInt(st.nextToken()));
				break;
			}
		}
		out.println(sb.toString().trim());

		out.close();
	}
}

class LazySegmentTree {
	final int MAX = 1000000;
	long tree[] = new long[MAX];
	long lazy[] = new long[MAX];

	void updateRangeUtil(int actual, int leftNode, int rigthNode, int leftFind, int rigthFind, int add) {
		if (lazy[actual] != 0) {
			tree[actual] += lazy[actual];
			if (leftNode != rigthNode) {
				lazy[actual * 2 + 1] += lazy[actual];
				lazy[actual * 2 + 2] += lazy[actual];
			}
			lazy[actual] = 0;
		}

		if (leftNode > rigthNode || leftNode > rigthFind || rigthNode < leftFind)
			return;

		if (leftNode >= leftFind && rigthNode <= rigthFind) {
			tree[actual] += add;
			if (leftNode != rigthNode) {
				lazy[actual * 2 + 1] += add;
				lazy[actual * 2 + 2] += add;
			}
			return;
		}

		int mid = (leftNode + rigthNode) / 2;
		updateRangeUtil(actual * 2 + 1, leftNode, mid, leftFind, rigthFind, add);
		updateRangeUtil(actual * 2 + 2, mid + 1, rigthNode, leftFind, rigthFind, add);

		tree[actual] = Math.max(tree[actual * 2 + 1], tree[actual * 2 + 2]);
	}

	void updateRange(int n, int us, int ue, int diff) {
		updateRangeUtil(0, 0, n - 1, us, ue, diff);
	}

	long getMaxUtil(int ss, int se, int qs, int qe, int si) {
		if (lazy[si] != 0) {
			tree[si] += lazy[si];

			if (ss != se) {
				lazy[si * 2 + 1] += lazy[si];
				lazy[si * 2 + 2] += lazy[si];
			}

			lazy[si] = 0;
		}

		if (ss > se || ss > qe || se < qs)
			return Integer.MIN_VALUE;

		if (ss >= qs && se <= qe)
			return tree[si];

		int mid = (ss + se) / 2;
		return Math.max(getMaxUtil(ss, mid, qs, qe, 2 * si + 1), getMaxUtil(mid + 1, se, qs, qe, 2 * si + 2));
	}

	long getSum(int n, int qs, int qe) {
		if (qs < 0 || qe > n - 1 || qs > qe) {
			return -1;
		}

		return getMaxUtil(0, n - 1, qs, qe, 0);
	}

	void constructSTUtil(long arr[], int ss, int se, int si) {
		if (ss > se) {
			tree[si] = Integer.MIN_VALUE;
			return;
		}

		if (ss == se) {
			tree[si] = arr[ss];
			return;
		}

		int mid = (ss + se) / 2;
		constructSTUtil(arr, ss, mid, si * 2 + 1);
		constructSTUtil(arr, mid + 1, se, si * 2 + 2);

		// aca se va a cojerla suma enla contruccion del arbol
		tree[si] = Math.max(tree[si * 2 + 1], tree[si * 2 + 2]);
	}

	void constructST(long arr[], int n) {
		constructSTUtil(arr, 0, n - 1, 0);
	}
}
