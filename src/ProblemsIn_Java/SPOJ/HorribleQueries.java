package ProblemsIn_Java.SPOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HorribleQueries {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(br);
		PrintWriter out = new PrintWriter(System.out);

		SegmentTree stlp;
		StringTokenizer st;
		long A[];
		int t = in.nextInt();
		for (int c = 0; c < t; c++) {
			A = new long[in.nextInt()];
			stlp = new SegmentTree(A);
			int q = in.nextInt();
			int a,b;
			for (int query = 0; query < q; query++) {
				switch (in.nextInt()) {
				case 0:
					a = in.nextInt()-1;
					b = in.nextInt()-1;
					long v = in.nextLong();
					stlp.update(a, b, v);
					break;
				case 1:
					a = in.nextInt()-1;
					b = in.nextInt()-1;
					out.println(stlp.query(a, b));
					break;
				}
			}
		}

		out.close();
		in.close();
	}

	static class SegmentTree {
		int N;
		Node[] tree;

		class Node {
			public int start, end;
			public long sum, add;

			public Node(int l, int r) {
				start = l;
				end = r;
			}

			public void merge(Node l, Node r) {
				if (l == null)
					sum = r.sum + r.add * (r.end - r.start + 1);
				else if (r == null)
					sum = l.sum + l.add * (l.end - l.start + 1);
				else
					sum = l.sum + l.add * (l.end - l.start + 1) + r.sum + r.add * (r.end - r.start + 1);
			}

			public void split(int l, int r) {
				sum += add * (end - start + 1);
				if (end != start) {
					Node leftChild = tree[l];
					leftChild.add += add;
					Node rightChild = tree[r];
					rightChild.add += add;
				}
				add = 0;
			}
		}

		public SegmentTree(long[] A) {
			N = A.length;
			int power = (int) Math.floor(Math.log(A.length) / Math.log(2)) + 1;
			int len = (int) Math.pow(2, power);
			tree = new Node[len];
			build(1, 0, A.length - 1, A);
		}

		private void build(int node, int l, int r, long[] A) {
			if (l == r) {
				tree[node] = new Node(l, r);
				tree[node].sum = A[l];
				return;
			}
			int nL = node << 1, nR = nL + 1, mid = (l + r) >> 1;
			build(nL, l, mid, A);
			build(nR, mid + 1, r, A);
			tree[node] = new Node(l, r);
			tree[node].merge(tree[nL], tree[nR]);
		}

		public void update(int i, int j, long val) {
			update(1, 0, N - 1, i, j, val);
		}

		private void update(int node, int l, int r, int i, int j, long val) {
			int nL = node << 1, nR = nL + 1, mid = (l + r) >> 1;
			if (i <= l && j >= r) {
				tree[node].add += val;
				tree[node].split(nL, nR);
				return;
			}
			if (j < l || i > r)
				return;
			update(nL, l, mid, i, j, val);
			update(nR, mid + 1, r, i, j, val);
			tree[node].merge(tree[nL], tree[nR]);
		}

		public long query(int i, int j) {
			return query(1, 0, N - 1, i, j).sum;
		}

		private Node query(int node, int l, int r, int i, int j) {
			int nL = node << 1, nR = nL + 1, mid = (l + r) >> 1;
			if (l >= i && r <= j) {
				if (tree[node].add > 0)
					tree[node].split(nL, nR);
				return tree[node];
			}
			if (j < l || i > r)
				return null;
			if (tree[node].add > 0)
				tree[node].split(nL, nR);
			Node a = query(nL, l, mid, i, j);
			Node b = query(nR, mid + 1, r, i, j);
			Node temp = new Node(-1, -1);
			temp.merge(a, b);
			return temp;
		}
	}
}
