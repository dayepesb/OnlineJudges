package ProblemsIn_Java.LiveArchive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Potentiometers {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		// PrintWriter out = new PrintWriter(new File("Debug.txt"));

		StringTokenizer st;
		int tam;
		int[] array;

		for (int k = 1;; k++) {
			tam = Integer.parseInt(in.readLine().trim());
			if (tam == 0)
				break;
			if (k > 1)
				out.println();
			out.printf("Case %d:%n", k);
			array = new int[tam];
			for (int i = 0; i < array.length; i++) {
				array[i] = Integer.parseInt(in.readLine().trim());
			}

			STNode sn = new STNode().constructor(array, 0, tam - 1);

			while (true) {
				st = new StringTokenizer(in.readLine());
				String consul = st.nextToken();
				if (consul.equalsIgnoreCase("M")) {
					int index1 = Integer.parseInt(st.nextToken()) - 1;
					int index2 = Integer.parseInt(st.nextToken()) - 1;
					out.println(sn.getSum(sn, index1, index2));
				} else if (consul.equalsIgnoreCase("S")) {
					int index1 = Integer.parseInt(st.nextToken()) - 1;
					int valor = Integer.parseInt(st.nextToken());
					sn.updateValueAtIndex(sn, index1, valor);
				} else if (consul.equalsIgnoreCase("END")) {
					break;
				}
			}
		}

		out.close();
		in.close();
	}

	public static class STNode {
		int leftIndex;
		int rightIndex;
		int sum;
		STNode leftNode;
		STNode rightNode;

		public static STNode constructor(int[] A, int l, int r) {
			if (l == r) {
				STNode node = new STNode();
				node.leftIndex = l;
				node.rightIndex = r;
				node.sum = A[l];
				return node;
			}
			int mid = (l + r) / 2;
			STNode leftNode = constructor(A, l, mid);
			STNode rightNode = constructor(A, mid + 1, r);
			STNode root = new STNode();
			root.leftIndex = leftNode.leftIndex;
			root.rightIndex = rightNode.rightIndex;
			root.sum = leftNode.sum + rightNode.sum;
			root.leftNode = leftNode;
			root.rightNode = rightNode;
			return root;
		}

		public static int getSum(STNode root, int l, int r) {
			if (root.leftIndex >= l && root.rightIndex <= r) {
				return root.sum;
			}
			if (root.rightIndex < l || root.leftIndex > r) {
				return 0;
			}
			return getSum(root.leftNode, l, r) + getSum(root.rightNode, l, r);
		}

		public static int updateValueAtIndex(STNode root, int index, int newValue) {
			int diff = 0;
			if (root.leftIndex == root.rightIndex && index == root.leftIndex) {
				diff = newValue - root.sum;
				root.sum = newValue;
				return diff;
			}
			int mid = (root.leftIndex + root.rightIndex) / 2;
			if (index <= mid) {
				diff = updateValueAtIndex(root.leftNode, index, newValue);
			} else {
				diff = updateValueAtIndex(root.rightNode, index, newValue);
			}
			root.sum += diff;
			return diff;
		}
	}

}
