package ProblemsIn_Java.CampamentoCuba2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TomAndHisFriends {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(in.readLine());
		long n = Long.parseLong(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(in.readLine());

		ArtificialST ast = new ArtificialST(n - 1);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int color = Integer.parseInt(st.nextToken().trim());
			long l = Long.parseLong(st.nextToken()) - 1;
			long r = Long.parseLong(st.nextToken()) - 1;
			ast.update(l, r, color);
		}
		long[] arr = new long[(int) k];

		StringBuilder sb = new StringBuilder("");
		ast.arrayMaker(arr);
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + " ");
		}
		out.print(sb.toString().trim());
		out.close();
	}

}

class ArtificialST {
	Node root;
	int n;

	public ArtificialST(long n) {
		// root = construction(0,n);
		root = new Node(0, n, true);
		// criterio
		root.value = -1;

	}

	public void arrayMaker(long[] arr) {
		long validez = -1;
		arrayMaker(arr, root);
	}

	private void arrayMaker(long[] arr, Node v) {
		if (!v.flag) {
			if (v.left != null)
				arrayMaker(arr, v.left);
			if (v.right != null)
				arrayMaker(arr, v.right);
		} else {
			arr[(int) (v.value - 1)] += v.j - v.i + 1;
		}
	}

	public void update(long i, long j, long c) {
		update(i, j, c, root);
	}

	private void update(long i, long j, long c, Node v) {
		if (v.i >= i && v.j <= j) {
			v.flag = true;
			v.value = c;
			v.left = null;
			v.right = null;
			return;
		}
		long mid = (v.i + v.j) / 2;

		if (c != v.value && v.value != -1) {
			if (v.left == null)
				v.left = new Node(v.i, mid, true);
			v.left.value = v.value;
			v.left.flag = true;
			update(v.i, mid, v.value, v.left);

			if (v.right == null)
				v.right = new Node(mid + 1, v.j, true);
			v.right.value = v.value;
			v.right.flag = true;
			update(mid + 1, v.j, v.value, v.right);

			v.flag = false;
			v.value = -1;

		}

		if (i < mid + 1 && j < mid + 1) {
		} else if (i > mid && j > mid) {
			createRNode(i, j, c, v);
		} else {
			if (i <= mid) {
				createLNode(i, mid, c, v);
			}

			if (j > mid) {
				createRNode(mid + 1, j, c, v);
			}

		}
		if (!v.flag && v.left != null && v.right != null && v.left.value == v.right.value && v.right.flag
				&& v.right.flag) {
			v.value = v.left.value;
			v.flag = true;
			v.left = null;
			v.right = null;
		}
		return;

	}

	private void createLNode(long i, long j, long c, Node v) {
		if (v.left == null)
			v.left = new Node(v.i, j, false);
		v.left.flag = v.flag;
		v.flag = false;
		update(i, j, c, v.left);

	}

	private void createRNode(long i, long j, long c, Node v) {
		if (v.right == null)
			v.right = new Node(i, v.j, false);
		v.right.flag = v.flag;
		v.flag = false;
		update(i, j, c, v.right);

	}

	class Node {
		public boolean flag;
		public Node left;
		public Node right;
		public long i;
		public long j;
		// public long i2;
		// public long j2;
		public long value;

		public Node(long i, long j, boolean flag) {
			this.flag = flag;
			this.i = i;
			this.j = j;
			this.value = -1;
			this.left = null;
			this.right = null;
		}
	}

	/*
	 * 
	 * 5 3 4 1 3 4 2 4 5 3 2 3 1 5 5
	 * 
	 * 5 3 3 1 1 5 2 2 4 1 3 3
	 * 
	 * 
	 * 5 3 3 1 3 4 2 4 5 3 2 3
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 *
	 * 40 10 3 1 10 20 2 8 8 9 22 22
	 * 
	 * if(!v.flag&&v.left!=null&&v.right!=null&&v.left.value==v.right.value&&v.right
	 * .flag&&v.right.flag)
	 * 
	 * { v.value = v.left.value; v.flag = true; v.left = null; v.right = null; }
	 */
}
