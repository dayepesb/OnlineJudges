package ProblemsIn_Java.CampamentoCuba2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RangeVariationQuery {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int n = 100100, a = 12345, b = 23456;
		long array[] = new long[n];
		for (int i = 1; i < n; i++) {
			long a2 = (long) (Math.pow(((i) % a), 2) % a) % a;
			long b2 = (long) (Math.pow(((i) % b), 3) % b) % b;
			array[i - 1] = (long) (a2 + b2);
		}
		SegmentTreeMax stMax = new SegmentTreeMax(array);
		SegmentTreeMin stMin = new SegmentTreeMin(array);
		int q = Integer.parseInt(in.readLine().trim());
		while (q-- > 0) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Integer.parseInt(st.nextToken());
			if (x > 0) {
				// query
				x -= 1;
				y -= 1;
				long max = stMax.queryOfRange((int) x, (int) y);
				long min = stMin.queryOfRange((int) x, (int) y);
				out.println(max - min);
			} else {
				// uodate
				x *= -1;
				stMax.updateValue((int) x - 1, y);
				stMin.updateValue((int) x - 1, y);
			}
		}
		out.close();
		in.close();
	}
}

class SegmentTreeMax {
	private long[] segmentTree;
	private long[] arr;
	private int n;

	public SegmentTreeMax(long[] arr) {
		int x = (int) (Math.ceil(Math.log(arr.length) / Math.log(2)));
		int m = 2 * (int) Math.pow(2, x) - 1;
		n = arr.length;
		segmentTree = new long[m];
		this.arr = arr;
		constructionSegmentTree(0, n - 1, 0);
	}

	private void constructionSegmentTree(int i, int j, int p) {
		if (i == j) {
			segmentTree[p] = arr[i];
			return;
		}
		int m = (i + j) / 2;
		constructionSegmentTree(i, m, 2 * p + 1);
		constructionSegmentTree(m + 1, j, 2 * p + 2);
		// Criterio
		segmentTree[p] = Math.max(segmentTree[2 * p + 1], segmentTree[2 * p + 2]);
	}

	public long queryOfRange(int i, int j) {
		return queryOfRange(i, j, 0, n - 1, 0);
	}

	private long queryOfRange(int i, int j, int k, int l, int p) {
		if (k >= i && l <= j)
			return segmentTree[p];
		if (j < k || i > l)
			return Long.MIN_VALUE;
		// Criterio
		return Math.max(queryOfRange(i, j, k, (k + l) / 2, p * 2 + 1),
				queryOfRange(i, j, (k + l) / 2 + 1, l, p * 2 + 2));
	}

	public void updateValue(int i, long value) {
		update(i, 0, n - 1, 0, value);
	}

	private void update(int i, int k, int l, int p, long value) {
		if (k == l) {
			if (k == i)
				segmentTree[p] = value;
			return;
		}
		if (k <= i && i <= l) {
			update(i, k, (k + l) / 2, p * 2 + 1, value);
			update(i, (k + l) / 2 + 1, l, p * 2 + 2, value);
			// Criterio
			segmentTree[p] = Math.max(segmentTree[p * 2 + 1], segmentTree[p * 2 + 2]);
			return;
		}
	}
}

// ___________________________________________________________________________________________
class SegmentTreeMin {
	private long[] segmentTree;
	private long[] arr;
	private int n;

	public SegmentTreeMin(long[] arr) {
		int x = (int) (Math.ceil(Math.log(arr.length) / Math.log(2)));
		int m = 2 * (int) Math.pow(2, x) - 1;
		n = arr.length;
		segmentTree = new long[m];
		this.arr = arr;
		constructionSegmentTree(0, n - 1, 0);
	}

	private void constructionSegmentTree(int i, int j, int p) {
		if (i == j) {
			segmentTree[p] = arr[i];
			return;
		}
		int m = (i + j) / 2;
		constructionSegmentTree(i, m, 2 * p + 1);
		constructionSegmentTree(m + 1, j, 2 * p + 2);
		// Criterio
		segmentTree[p] = Math.min(segmentTree[2 * p + 1], segmentTree[2 * p + 2]);
	}

	public long queryOfRange(int i, int j) {
		return queryOfRange(i, j, 0, n - 1, 0);
	}

	private long queryOfRange(int i, int j, int k, int l, int p) {
		if (k >= i && l <= j)
			return segmentTree[p];
		if (j < k || i > l)
			return Long.MAX_VALUE;
		// Criterio
		return Math.min(queryOfRange(i, j, k, (k + l) / 2, p * 2 + 1),
				queryOfRange(i, j, (k + l) / 2 + 1, l, p * 2 + 2));
	}

	public void updateValue(int i, long value) {
		update(i, 0, n - 1, 0, value);
	}

	private void update(int i, int k, int l, int p, long value) {
		if (k == l) {
			if (k == i)
				segmentTree[p] = value;
			return;
		}
		if (k <= i && i <= l) {
			update(i, k, (k + l) / 2, p * 2 + 1, value);
			update(i, (k + l) / 2 + 1, l, p * 2 + 2, value);
			// Criterio
			segmentTree[p] = Math.min(segmentTree[p * 2 + 1], segmentTree[p * 2 + 2]);
			return;
		}
	}
}