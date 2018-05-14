package ProblemsIn_Java.Notebook_Camus.DataStrutures;

class SegmentTreeLazyPropagation {
	class SegmentTree {
		int N; Node[] tree;
		public SegmentTree(int[] A) {
			N = A.length;
			int power = (int) Math.floor(Math.log(A.length) / Math.log(2)) + 1;
			int len = 2 * (int) Math.pow(2, power);
			tree = new Node[len]; build(1, 0, A.length - 1, A); }
		private void build(int node, int l, int r, int[] A) {
			if (l == r) {// nodo hoja
				tree[node] = new Node(l, r); tree[node].value = A[l];
				return; }
			int leftChild = node * 2, rightChild = leftChild + 1, mid = (l + r) / 2;
			build(leftChild, l, mid, A); // calcular el valor del hijo izquierdo
			build(rightChild, mid + 1, r, A); // calcular el valor del hijo derecho
			tree[node] = new Node(l, r);
			tree[node].merge(tree[leftChild], tree[rightChild]);
		}
		private Node query(int node, int l, int r, int i, int j) {
			int leftChild = 2 * node, rightChild = leftChild + 1, mid = (l + r) / 2;
			if (l >= i && r <= j) {
				if (tree[node].flag) tree[node].split(leftChild, rightChild);
				return tree[node];}
			if (j < l || i > r) return null;
			if (tree[node].flag) tree[node].split(leftChild, rightChild); // nodo visitado
			Node a = query(leftChild, l, mid, i, j);
			Node b = query(rightChild, mid + 1, r, i, j);
			Node temp = new Node(N, N);
			temp.merge(a, b); return temp; }
		public int query(int i, int j) {
			Node result = query(1, 0, N - 1, i, j); return result.value; }
		private void update(int node, int l, int r, int i, int j, int v) {
			int leftChild = 2 * node, rightChild = leftChild + 1, mid = (l + r) / 2;
			if (i <= l && j >= r) {
				tree[node].updated = v; tree[node].flag = true;
				tree[node].split(leftChild, rightChild);
			} else if (j < l || i > r) return;
			else {
			update(leftChild, l, mid, i, j, v); update(rightChild, mid + 1, r, i, j, v);
			tree[node].merge(tree[leftChild], tree[rightChild]);
			}
		}
		public void update(int i, int j, int newValue) {
			update(1, 0, N - 1, i, j, newValue);}
		class Node {
			boolean flag; int left, right, value, updated;
			public Node(int l, int r) { left = l; right = r; }
			public void merge(Node leftChild, Node rightChild) {
				if (leftChild == null) value = rightChild.value;
				else if (rightChild == null) value = leftChild.value;
				else value = Math.min(leftChild.value, rightChild.value);
			}
			public void split(int nL, int nR) {
				// marcar los hijos
				if (left != right) { Node leftChild = tree[nL];
					leftChild.flag = true; leftChild.updated = updated;
					Node rightChild = tree[nR]; rightChild.flag = true;
					rightChild.updated = updated; }
				flag = false; value = updated;
			}
		}
	}
}
