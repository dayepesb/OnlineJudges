package ProblemsIn_Java.NoteBook;

public class EstructurasDeDatos {
	public static void main(String[] args) {

	}

	/*
	 * Arbol de Segmentos.
	 */
	class STNode {
		int leftIndex;
		int rightIndex;
		int sum;
		STNode leftNode;
		STNode rightNode;

		public STNode(int[] A, int l, int r) {
			if (l == r) {
				this.leftIndex = l;
				this.rightIndex = r;
				this.sum = A[l];
			} else {
				int mid = (l + r) / 2;
				STNode leftNode = new STNode(A, l, mid);
				STNode rightNode = new STNode(A, mid + 1, r);
				this.leftIndex = leftNode.leftIndex;
				this.rightIndex = rightNode.rightIndex;
				this.sum = leftNode.sum + rightNode.sum;
				this.leftNode = leftNode;
				this.rightNode = rightNode;
			}
		}

		public int getSum(STNode root, int l, int r) {
			if (root.leftIndex >= l && root.rightIndex <= r) {
				return root.sum;
			}
			if (root.rightIndex < l || root.leftIndex > r) {
				return 0;
			}
			return getSum(root.leftNode, l, r) + getSum(root.rightNode, l, r);
		}

		public int updateValueAtIndex(STNode root, int index, int newValue) {
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

	/*
	 * Este arbol devuelve los signos de las multiplicaciones en una arreglo
	 */

	class STNodeProductSing {
		int leftIndex;
		int rightIndex;
		char product;
		STNodeProductSing leftNode;
		STNodeProductSing rightNode;

		public STNodeProductSing(char A[], int l, int r) {
			if (l == r) {
				this.leftIndex = l;
				this.rightIndex = r;
				this.product = A[l];
			} else {
				int mid = (l + r) / 2;
				STNodeProductSing leftNode = new STNodeProductSing(A, l, mid);
				STNodeProductSing rightNode = new STNodeProductSing(A, mid + 1, r);
				this.leftIndex = l;
				this.rightIndex = r;
				char res = '0', a = leftNode.product, b = rightNode.product;
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

		public char getProduct(STNodeProductSing root, int l, int r) {
			if (root.leftIndex >= l && root.rightIndex <= r) {
				return root.product;
			}
			if (root.rightIndex < l || root.leftIndex > r) {
				return '+';
			}
			char a = getProduct(root.leftNode, l, r), b = getProduct(root.rightNode, l, r), res = '+';
			if (a == '0' || b == '0') {
				res = '0';
			} else if ((a == '-' && b == '+') || (a == '+' && b == '-')) {
				res = '-';
			} else {
				res = '+';
			}
			return res;
		}

		public char updateValueAtIndex(STNodeProductSing root, int index, char newValue) {
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

			char res = '+', a = root.leftNode.product, b = root.rightNode.product;
			if (a == '0' || b == '0') {
				res = '0';
			} else if ((a == '+' && b == '-') || ((a == '-' && b == '+'))) {
				res = '-';
			} else {
				res = '+';
			}

			root.product = res;
			return res;
		}

		@Override
		public String toString() {
			return this.product + " : " + this.leftIndex + " : " + this.rightIndex;
		}
	}

	class UnionFind {
		/*
		 * Recordar que para el conjunto inicial que son los padres de cada uno esten
		 * rellenos con -1 que indica que ellos son los lideren de su propia componente.
		 */
		int set[];

		void union(int x, int y) {
			x = find(x);
			y = find(y);

			if (x == y)
				return;

			int sizex = -(set[x]);
			int sizey = -(set[y]);

			if (sizex < sizey) {
				set[y] = set[y] + set[x];
				set[x] = y;
			} else {
				set[x] = set[x] + set[y];
				set[y] = x;
			}

		}

		/*
		 * Busca el padre o nodo raiz en este arbol
		 */
		int find(int x) {
			if (set[x] < 0)
				return x;
			else
				return set[x] = find(set[x]);
		}

	}

	class SegmentTree_2 {
		class SegmentTree {
			int N;
			Node[] tree;

			public SegmentTree(int[] A) {
				N = A.length;
				int power = (int) Math.floor(Math.log(A.length) / Math.log(2)) + 1;
				int len = 2 * (int) Math.pow(2, power);
				tree = new Node[len];
				build(1, 0, A.length - 1, A);
			}

			private void build(int node, int l, int r, int[] A) {
				if (l == r) // nodo hoja
				{
					tree[node] = new Node(l, r);
					tree[node].value = A[l];
					return;
				}
				int leftChild = node * 2, rightChild = leftChild + 1, mid = (l + r) / 2;
				build(leftChild, l, mid, A); // calcular el valor del hijo izquierdo
				build(rightChild, mid + 1, r, A); // calcular el valor del hijo derecho
				tree[node] = new Node(l, r);
				tree[node].merge(tree[leftChild], tree[rightChild]);
			}

			private Node query(int node, int l, int r, int i, int j) {
				if (l >= i && r <= j)
					return tree[node]; // dentro del intervalo
				else if (j < l || i > r)
					return null; // fuera del intervalo
				else // parcialmente dentro
				{
					int leftChild = 2 * node, rightChild = leftChild + 1, mid = (l + r) / 2;
					Node a = query(leftChild, l, mid, i, j); // visitar hijo izquierdo
					Node b = query(rightChild, mid + 1, r, i, j); // visitar hijo derecho
					Node temp = new Node(-1, -1); // combinamos la informacion
					temp.merge(a, b);
					return temp;
				}
			}

			public int query(int i, int j) {
				Node result = query(1, 0, N - 1, i, j);
				return result.value;
			}

			private void update(int node, int l, int r, int i, int v) {
				if (l == i && l == r)
					tree[node].value = v; // nodo hoja
				else if (i < l || i > r)
					return; // fuera del intervalo
				else // parcialmente dentro
				{
					int leftChild = 2 * node, rightChild = leftChild + 1, mid = (l + r) / 2;
					update(leftChild, l, mid, i, v); // visitar hijo izquierdo
					update(rightChild, mid + 1, r, i, v); // visitar hijo derecho
					tree[node].merge(tree[leftChild], tree[rightChild]);
				}
			}

			public void update(int i, int newValue) {
				update(1, 0, N - 1, i, newValue);
			}
		}

		class Node {
			int left, right, value;

			public Node(int l, int r) {
				left = l;
				right = r;
			}

			// En este metoedo se determina la operaci�n que se quiere hacer
			public void merge(Node leftChild, Node rightChild) {
				if (leftChild == null)
					value = rightChild.value;
				else if (rightChild == null)
					value = leftChild.value;
				else
					value = Math.min(leftChild.value, rightChild.value);
			}
		}
	}

	class SegmentTreeLazyPropagation {
		class SegmentTree {
			int N;
			Node[] tree;

			public SegmentTree(int[] A) {
				N = A.length;
				int power = (int) Math.floor(Math.log(A.length) / Math.log(2)) + 1;
				int len = 2 * (int) Math.pow(2, power);
				tree = new Node[len];
				build(1, 0, A.length - 1, A);
			}

			private void build(int node, int l, int r, int[] A) {
				if (l == r) // nodo hoja
				{
					tree[node] = new Node(l, r);
					tree[node].value = A[l];
					return;
				}
				int leftChild = node * 2, rightChild = leftChild + 1, mid = (l + r) / 2;
				build(leftChild, l, mid, A); // calcular el valor del hijo izquierdo
				build(rightChild, mid + 1, r, A); // calcular el valor del hijo derecho
				tree[node] = new Node(l, r);
				tree[node].merge(tree[leftChild], tree[rightChild]);
			}

			private Node query(int node, int l, int r, int i, int j) {
				int leftChild = 2 * node, rightChild = leftChild + 1, mid = (l + r) / 2;
				if (l >= i && r <= j) {
					if (tree[node].flag)
						tree[node].split(leftChild, rightChild);
					return tree[node];
				}
				if (j < l || i > r)
					return null;
				if (tree[node].flag)
					tree[node].split(leftChild, rightChild); // nodo visitado
				Node a = query(leftChild, l, mid, i, j);
				Node b = query(rightChild, mid + 1, r, i, j);
				Node temp = new Node(N, N);
				temp.merge(a, b);
				return temp;
			}

			public int query(int i, int j) {
				Node result = query(1, 0, N - 1, i, j);
				return result.value;
			}

			private void update(int node, int l, int r, int i, int j, int v) {
				int leftChild = 2 * node, rightChild = leftChild + 1, mid = (l + r) / 2;
				if (i <= l && j >= r) {
					tree[node].updated = v;
					tree[node].flag = true;
					tree[node].split(leftChild, rightChild);
				} else if (j < l || i > r)
					return;
				else {
					update(leftChild, l, mid, i, j, v);
					update(rightChild, mid + 1, r, i, j, v);
					tree[node].merge(tree[leftChild], tree[rightChild]);
				}
			}

			public void update(int i, int j, int newValue) {
				update(1, 0, N - 1, i, j, newValue);
			}

			class Node {
				boolean flag;
				int left, right, value, updated;

				public Node(int l, int r) {
					left = l;
					right = r;
				}

				public void merge(Node leftChild, Node rightChild) {
					if (leftChild == null)
						value = rightChild.value;
					else if (rightChild == null)
						value = leftChild.value;
					else
						value = Math.min(leftChild.value, rightChild.value);
				}

				public void split(int nL, int nR) {
					// marcar los hijos
					if (left != right) {
						Node leftChild = tree[nL];
						leftChild.flag = true;
						leftChild.updated = updated;
						Node rightChild = tree[nR];
						rightChild.flag = true;
						rightChild.updated = updated;
					}
					flag = false;
					value = updated;
				}
			}
		}
	}

	class LazySegmentTreeCorrect {
		final int MAX = 1000;
		int tree[] = new int[MAX];
		int lazy[] = new int[MAX];

		/*
		 * si -> index of current node in segment tree ss and se -> Starting and ending
		 * indexes of elements for which current nodes stores sum. us and eu -> starting
		 * and ending indexes of update query ue -> ending index of update query diff ->
		 * which we need to add in the range us to ue
		 */
		void updateRangeUtil(int si, int ss, int se, int us, int ue, int diff) {
			// If lazy value is non-zero for current node of segment
			// tree, then there are some pending updates. So we need
			// to make sure that the pending updates are done before
			// making new updates. Because this value may be used by
			// parent after recursive calls (See last line of this
			// function)
			if (lazy[si] != 0) {
				// Make pending updates using value stored in lazy
				// nodes
				tree[si] += (se - ss + 1) * lazy[si];

				// checking if it is not leaf node because if
				// it is leaf node then we cannot go further
				if (ss != se) {
					// We can postpone updating children we don't
					// need their new values now.
					// Since we are not yet updating children of si,
					// we need to set lazy flags for the children
					lazy[si * 2 + 1] += lazy[si];
					lazy[si * 2 + 2] += lazy[si];
				}

				// Set the lazy value for current node as 0 as it
				// has been updated
				lazy[si] = 0;
			}

			// out of range
			if (ss > se || ss > ue || se < us)
				return;

			// Current segment is fully in range
			if (ss >= us && se <= ue) {
				// Add the difference to current node
				tree[si] += (se - ss + 1) * diff;

				// same logic for checking leaf node or not
				if (ss != se) {
					// This is where we store values in lazy nodes,
					// rather than updating the segment tree itelf
					// Since we don't need these updated values now
					// we postpone updates by storing values in lazy[]
					lazy[si * 2 + 1] += diff;
					lazy[si * 2 + 2] += diff;
				}
				return;
			}

			// If not completely in rang, but overlaps, recur for
			// children,
			int mid = (ss + se) / 2;
			updateRangeUtil(si * 2 + 1, ss, mid, us, ue, diff);
			updateRangeUtil(si * 2 + 2, mid + 1, se, us, ue, diff);

			// And use the result of children calls to update this
			// node
			tree[si] = tree[si * 2 + 1] + tree[si * 2 + 2];
		}

		// Function to update a range of values in segment
		// tree
		/*
		 * us and eu -> starting and ending indexes of update query ue -> ending index
		 * of update query diff -> which we need to add in the range us to ue
		 */
		void updateRange(int n, int us, int ue, int diff) {
			updateRangeUtil(0, 0, n - 1, us, ue, diff);
		}

		/*
		 * A recursive function to get the sum of values in given range of the array.
		 * The following are parameters for this function. si --> Index of current node
		 * in the segment tree. Initially 0 is passed as root is always at' index 0 ss &
		 * se --> Starting and ending indexes of the segment represented by current
		 * node, i.e., tree[si] qs & qe --> Starting and ending indexes of query range
		 */
		int getSumUtil(int ss, int se, int qs, int qe, int si) {
			// If lazy flag is set for current node of segment tree,
			// then there are some pending updates. So we need to
			// make sure that the pending updates are done before
			// processing the sub sum query
			if (lazy[si] != 0) {
				// Make pending updates to this node. Note that this
				// node represents sum of elements in arr[ss..se] and
				// all these elements must be increased by lazy[si]
				tree[si] += (se - ss + 1) * lazy[si];

				// checking if it is not leaf node because if
				// it is leaf node then we cannot go further
				if (ss != se) {
					// Since we are not yet updating children os si,
					// we need to set lazy values for the children
					lazy[si * 2 + 1] += lazy[si];
					lazy[si * 2 + 2] += lazy[si];
				}

				// unset the lazy value for current node as it has
				// been updated
				lazy[si] = 0;
			}

			// Out of range
			if (ss > se || ss > qe || se < qs)
				return 0;

			// At this point sure, pending lazy updates are done
			// for current node. So we can return value (same as
			// was for query in our previous post)

			// If this segment lies in range
			if (ss >= qs && se <= qe)
				return tree[si];

			// If a part of this segment overlaps with the given
			// range
			int mid = (ss + se) / 2;
			return getSumUtil(ss, mid, qs, qe, 2 * si + 1) + getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
		}

		// Return sum of elements in range from index qs (query
		// start) to qe (query end). It mainly uses getSumUtil()
		int getSum(int n, int qs, int qe) {
			// Check for erroneous input values
			if (qs < 0 || qe > n - 1 || qs > qe) {
				System.out.println("Invalid Input");
				return -1;
			}

			return getSumUtil(0, n - 1, qs, qe, 0);
		}

		/*
		 * A recursive function that constructs Segment Tree for array[ss..se]. si is
		 * index of current node in segment tree st.
		 */
		void constructSTUtil(int arr[], int ss, int se, int si) {
			// out of range as ss can never be greater than se
			if (ss > se)
				return;

			/*
			 * If there is one element in array, store it in current node of segment tree
			 * and return
			 */
			if (ss == se) {
				tree[si] = arr[ss];
				return;
			}

			/*
			 * If there are more than one elements, then recur for left and right subtrees
			 * and store the sum of values in this node
			 */
			int mid = (ss + se) / 2;
			constructSTUtil(arr, ss, mid, si * 2 + 1);
			constructSTUtil(arr, mid + 1, se, si * 2 + 2);

			tree[si] = tree[si * 2 + 1] + tree[si * 2 + 2];
		}

		/*
		 * Function to construct segment tree from given array. This function allocates
		 * memory for segment tree and calls constructSTUtil() to fill the allocated
		 * memory
		 */
		void constructST(int arr[], int n) {
			// Fill the allocated memory st
			constructSTUtil(arr, 0, n - 1, 0);
		}

	}

	// Driver program to test above functions
	void test() {
		int arr[] = { 1, 3, 5, 7, 9, 11 };
		int n = arr.length;
		LazySegmentTreeCorrect tree = new LazySegmentTreeCorrect();

		// Build segment tree from given array
		tree.constructST(arr, n);

		// Print sum of values in array from index 1 to 3
		System.out.println("Sum of values in given range = " + tree.getSum(n, 1, 3));

		// Add 10 to all nodes at indexes from 1 to 5.
		tree.updateRange(n, 1, 5, 10);

		// Find sum after the value is updated
		System.out.println("Updated sum of values in given range = " + tree.getSum(n, 1, 3));
	}

	// Java Program to show segment tree operations like construction,
	// query and update
	class SegmentTree {
		int st[]; // The array that stores segment tree nodes

		/*
		 * Constructor to construct segment tree from given array. This constructor
		 * allocates memory for segment tree and calls constructSTUtil() to fill the
		 * allocated memory
		 */
		SegmentTree(int arr[], int n) {
			// Allocate memory for segment tree
			// Height of segment tree
			int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

			// Maximum size of segment tree
			int max_size = 2 * (int) Math.pow(2, x) - 1;

			st = new int[max_size]; // Memory allocation

			constructSTUtil(arr, 0, n - 1, 0);
		}

		// A utility function to get the middle index from corner indexes.
		int getMid(int s, int e) {
			return s + (e - s) / 2;
		}

		/*
		 * A recursive function to get the sum of values in given range of the array.
		 * The following are parameters for this function.
		 * 
		 * st --> Pointer to segment tree si --> Index of current node in the segment
		 * tree. Initially 0 is passed as root is always at index 0 ss & se --> Starting
		 * and ending indexes of the segment represented by current node, i.e., st[si]
		 * qs & qe --> Starting and ending indexes of query range
		 */
		int getSumUtil(int ss, int se, int qs, int qe, int si) {
			// If segment of this node is a part of given range, then return
			// the sum of the segment
			if (qs <= ss && qe >= se)
				return st[si];

			// If segment of this node is outside the given range
			if (se < qs || ss > qe)
				return 0;

			// If a part of this segment overlaps with the given range
			int mid = getMid(ss, se);
			return getSumUtil(ss, mid, qs, qe, 2 * si + 1) + getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
		}

		/*
		 * A recursive function to update the nodes which have the given index in their
		 * range. The following are parameters st, si, ss and se are same as
		 * getSumUtil() i --> index of the element to be updated. This index is in input
		 * array. diff --> Value to be added to all nodes which have i in range
		 */
		void updateValueUtil(int ss, int se, int i, int diff, int si) {
			// Base Case: If the input index lies outside the range of
			// this segment
			if (i < ss || i > se)
				return;

			// If the input index is in range of this node, then update the
			// value of the node and its children
			st[si] = st[si] + diff;
			if (se != ss) {
				int mid = getMid(ss, se);
				updateValueUtil(ss, mid, i, diff, 2 * si + 1);
				updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
			}
		}

		// The function to update a value in input array and segment tree.
		// It uses updateValueUtil() to update the value in segment tree
		void updateValue(int arr[], int n, int i, int new_val) {
			// Check for erroneous input index
			if (i < 0 || i > n - 1) {
				System.out.println("Invalid Input");
				return;
			}

			// Get the difference between new value and old value
			int diff = new_val - arr[i];

			// Update the value in array
			arr[i] = new_val;

			// Update the values of nodes in segment tree
			updateValueUtil(0, n - 1, i, diff, 0);
		}

		// Return sum of elements in range from index qs (quey start) to
		// qe (query end). It mainly uses getSumUtil()
		int getSum(int n, int qs, int qe) {
			// Check for erroneous input values
			if (qs < 0 || qe > n - 1 || qs > qe) {
				System.out.println("Invalid Input");
				return -1;
			}
			return getSumUtil(0, n - 1, qs, qe, 0);
		}

		// A recursive function that constructs Segment Tree for array[ss..se].
		// si is index of current node in segment tree st
		int constructSTUtil(int arr[], int ss, int se, int si) {
			// If there is one element in array, store it in current node of
			// segment tree and return
			if (ss == se) {
				st[si] = arr[ss];
				return arr[ss];
			}

			// If there are more than one elements, then recur for left and
			// right subtrees and store the sum of values in this node
			int mid = getMid(ss, se);
			st[si] = constructSTUtil(arr, ss, mid, si * 2 + 1) + constructSTUtil(arr, mid + 1, se, si * 2 + 2);
			return st[si];
		}

		// Driver program to test above functions
		public void mainsdd(String args[]) {
			int arr[] = { 1, 3, 5, 7, 9, 11 };
			int n = arr.length;
			SegmentTree tree = new SegmentTree(arr, n);

			// Build segment tree from given array

			// Print sum of values in array from index 1 to 3
			System.out.println("Sum of values in given range = " + tree.getSum(n, 1, 3));

			// Update: set arr[1] = 10 and update corresponding segment
			// tree nodes
			tree.updateValue(arr, n, 1, 10);

			// Find sum after the value is updated
			System.out.println("Updated sum of values in given range = " + tree.getSum(n, 1, 3));
		}
	}
	// This code is contributed by Ankur Narain Verma
}
