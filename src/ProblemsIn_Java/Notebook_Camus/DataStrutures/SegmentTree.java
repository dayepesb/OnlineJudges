package ProblemsIn_Java.Notebook_Camus.DataStrutures;

class SegmentTree {
	int N; Node[] tree;
	public SegmentTree(int[] A) {
		N = A.length;
		int power = (int) Math.floor(Math.log(A.length) / Math.log(2)) + 1;
		int len = 2 * (int) Math.pow(2, power); tree = new Node[len];
		build(1, 0, A.length - 1, A);}
	private void build(int node, int l, int r, int[] A) {
		// nodo hoja
		if (l == r) { tree[node] = new Node(l, r);
			tree[node].value = A[l]; return; }
		int leftChild = node * 2, rightChild = leftChild + 1, mid = (l + r) / 2;
		build(leftChild, l, mid, A); // calcular el valor del hijo izquierdo
		build(rightChild, mid + 1, r, A); // calcular el valor del hijo derecho
		tree[node] = new Node(l, r);
		tree[node].merge(tree[leftChild], tree[rightChild]);
	}
	private Node query(int node, int l, int r, int i, int j) {
		if (l >= i && r <= j) return tree[node]; // dentro del intervalo
		else if (j < l || i > r) return null; // fuera del intervalo
		// parcialmente dentro
		else {
			int leftChild = 2 * node, rightChild = leftChild + 1, mid = (l + r) / 2;
			Node a = query(leftChild, l, mid, i, j); // visitar hijo izquierdo
			Node b = query(rightChild, mid + 1, r, i, j); // visitar hijo derecho
			Node temp = new Node(-1, -1); // combinamos la informacion
			temp.merge(a, b); return temp;
		}
	}
	public int query(int i, int j) {
		Node result = query(1, 0, N - 1, i, j); return result.value; }
	private void update(int node, int l, int r, int i, int v) {
		if (l == i && l == r) tree[node].value = v; // nodo hoja
		else if (i < l || i > r) return; // fuera del intervalo
		else {// parcialmente dentro
			int leftChild = 2 * node, rightChild = leftChild + 1, mid = (l + r) / 2;
			update(leftChild, l, mid, i, v); // visitar hijo izquierdo
			update(rightChild, mid + 1, r, i, v); // visitar hijo derecho
			tree[node].merge(tree[leftChild], tree[rightChild]);}
	}
	public void update(int i, int newValue) {
		update(1, 0, N - 1, i, newValue);}
}
class Node {
	int left, right, value;
	public Node(int l, int r) {
		left = l; right = r;}
	// En este metoedo se determina la operaci�n que se quiere hacer
	public void merge(Node leftChild, Node rightChild) {
		if (leftChild == null) value = rightChild.value;
		else if (rightChild == null) value = leftChild.value;
		else value = Math.min(leftChild.value, rightChild.value);
	}
}