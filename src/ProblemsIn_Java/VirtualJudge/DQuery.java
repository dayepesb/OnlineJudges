package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @author david yepes buitrago
 * @date 01-08-2017
 * @time 0.000 ms
 */
public class DQuery {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int n,q,A[];
		STNode stlp;

//		STNode st1 = new STNode(new int[] { 1, 1, 2, 1, 3 }, 0, 4);
//		System.out.println(st1.getElements(st1, 0, 3));

		for(String line;(line=in.readLine())!=null;) {
			n = Integer.parseInt(line.trim());
			A = new int[n];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < n; i++) {
				A[i]=Integer.parseInt(st.nextToken());
			}
			stlp = new STNode(A, 0, n-1);
			q = Integer.parseInt(in.readLine().trim());
			for (int i = 0; i < q; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken()),b=Integer.parseInt(st.nextToken());
				out.println(stlp.differentElements(stlp, a-1, b-1));
			}
		}

		in.close();
		out.close();
	}

	static class STNode {
		int leftIndex, rightIndex;
		TreeSet<Integer> elements;
		STNode leftNode, rightNode;

		public STNode(int A[], int l, int r) {
			if (l == r) {
				this.leftIndex = l;
				this.rightIndex = r;
				this.elements = new TreeSet<>();
				elements.add(A[l]);
			} else {
				int mid = (l + r) / 2;
				STNode left = new STNode(A, l, mid), right = new STNode(A, mid + 1, r);
				this.leftIndex = left.leftIndex;
				this.rightIndex = right.rightIndex;
				this.elements = new TreeSet<>();
				elements.addAll(left.elements);
				elements.addAll(right.elements);
				this.leftNode = left;
				this.rightNode = right;
			}
		}

		public int differentElements(STNode st,int l,int r) {
			return getElements(st, l, r).size();
		}

		public TreeSet<Integer> getElements(STNode root, int l, int r) {
			if (root.leftIndex >= l && root.rightIndex <= r) {
				return root.elements;
			}
			if (root.rightIndex < l || root.leftIndex > r) {
				return new TreeSet<>();
			}
			TreeSet<Integer> resp = new TreeSet<>();
			resp.addAll(getElements(root.leftNode, l, r));
			resp.addAll(getElements(root.rightNode, l, r));
			return resp;
		}
	}
}
