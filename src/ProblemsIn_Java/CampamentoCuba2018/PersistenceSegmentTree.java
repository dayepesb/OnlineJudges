package ProblemsIn_Java.CampamentoCuba2018;

public class PersistenceSegmentTree {

	static class Node {
		int val;
		// Punteros a los hijos
		Node left, rigth;

		public Node(Node l, Node r, int value) {
			this.left = l;
			this.rigth = r;
			this.val = value;
		}
	}

	static int arr[];
	Node[] versions;

	public static void build(Node n, int l, int h) {
		if (l == h) {
			n.val = arr[l];
			return;
		}
		int mid = (l + h) / 2;
		n.left = new Node(null, null, 0);
		n.rigth = new Node(null, null, 0);
		build(n.left, l, mid);
		build(n.rigth, mid + 1, h);
		n.val = n.left.val + n.rigth.val;
	}

	public static void upgrade(Node prev, Node cur, int l, int h, int idx, int value) {
		if (idx > h || idx < l || l > h)
			return;
		// Modificaci�n en la nueva version
		if (l == h) {
			cur.val = value;
			return;
		}
		int mid = (l + h) / 2;
		if (idx <= mid) {
			// link to right child of previous version
			cur.rigth = prev.rigth;

			// create new node in current version
			cur.left = new Node(null, null, 0);

			upgrade(prev.left, cur.left, l, mid, idx, value);
		} else {
			// link to left child of previous version
			cur.left = prev.left;

			// create new node for current version
			cur.rigth = new Node(null, null, 0);

			upgrade(prev.rigth, cur.rigth, mid + 1, h, idx, value);
		}

		// calculating data for current version
		// by combining previous version and current
		// modification
		cur.val = cur.left.val + cur.rigth.val;
	}

	public static int query(Node n, int low, int high, int l, int r) {
		if (l > high || r < low || low > high)
			return 0;
		if (l <= low && high <= r)
			return n.val;
		int mid = (low + high) / 2;
		int p1 = query(n.left, low, mid, l, r);
		int p2 = query(n.rigth, mid + 1, high, l, r);
		return p1 + p2;
	}

	public static void main(String[] args) {
		int A[] = {1,2,3,4,5,6,7,8,9};
		
	}
}
