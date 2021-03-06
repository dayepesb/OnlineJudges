package ProblemsIn_Java.LiveArchive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class IntervalProduct {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		for (String line; (line = in.readLine()) != null;) {
			st = new StringTokenizer(line);
			int tam = Integer.parseInt(st.nextToken());
			int query = Integer.parseInt(st.nextToken());

			char A[] = new char[tam];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < tam; i++) {
				int val = Integer.parseInt(st.nextToken());
				A[i] = val < 0 ? '-' : (val == 0 ? '0' : '+');
			}

			STNode sn = new STNode(A, 0, tam - 1);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < query; i++) {
				st = new StringTokenizer(in.readLine());
				if (st.nextToken().equals("C")) {
					int index = Integer.parseInt(st.nextToken()) - 1;
					int val = Integer.parseInt(st.nextToken());
					char a = val < 0 ? '-' : (val == 0 ? '0' : '+');
					STNode.updateValueAtIndex(sn, index, a);
				} else {
					char res = STNode.getProduct(sn, Integer.parseInt(st.nextToken()) - 1,
							Integer.parseInt(st.nextToken()) - 1);
					sb.append(res);
				}
			}
			out.println(sb.toString());

		}

		out.close();
		in.close();
	}

	public static class STNode {
		int leftIndex;
		int rightIndex;
		char product;
		STNode leftNode;
		STNode rightNode;

		public STNode(char A[], int l, int r) {
			if (l == r) {
				this.leftIndex = l;
				this.rightIndex = r;
				this.product = A[l];
			} else {
				int mid = (l + r) / 2;
				STNode leftNode = new STNode(A, l, mid);
				STNode rightNode = new STNode(A, mid + 1, r);
				this.leftIndex = l;
				this.rightIndex = r;
				char res = '0';
				char a = leftNode.product;
				char b = rightNode.product;
				if (a == '0' || b == '0') {
					res = '0';
				} else if ((a == '+' && b == '+') || (a == '-' && b == '-')) {
					res = '+';
				} else if ((a == '+' && b == '-') || (a == '-' && b == '+')) {
					res = '-';
				}
				this.product = res;
				this.leftNode = leftNode;
				this.rightNode = rightNode;
			}
		}

		public static char getProduct(STNode root, int l, int r) {
			if (root.leftIndex >= l && root.rightIndex <= r) {
				return root.product;
			}
			if (root.rightIndex < l || root.leftIndex > r) {
				return '+';
			}
			char a = getProduct(root.leftNode, l, r);
			char b = getProduct(root.rightNode, l, r);
			char res;
			if (a == '0' || b == '0') {
				res = '0';
			} else if ((a == '-' && b == '+') || (a == '+' && b == '-')) {
				res = '-';
			} else {
				res = '+';
			}
			return res;
		}

		public static int updateValueAtIndex(STNode root, int index, char newValue) {
			if (root.leftIndex == root.rightIndex && index == root.leftIndex) {
				root.product = newValue;
				return newValue;
			}
			int mid = (root.leftIndex + root.rightIndex) / 2;
			if (index <= mid) {
				updateValueAtIndex(root.leftNode, index, newValue);
			} else {
				updateValueAtIndex(root.rightNode, index, newValue);
			}

			char a;
			if (root.leftNode.product == '0' || root.rightNode.product == '0') {
				a = '0';
			} else if ((root.leftNode.product == '+' && root.rightNode.product == '-')
					|| ((root.leftNode.product == '-' && root.rightNode.product == '+'))) {
				a = '-';
			} else {
				a = '+';
			}

			root.product = a;
			return root.product;
		}

		@Override
		public String toString() {
			return this.product + " : " + this.leftIndex + " : " + this.rightIndex;
		}
	}
}
