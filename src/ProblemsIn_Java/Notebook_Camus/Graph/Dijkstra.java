package ProblemsIn_Java.Notebook_Camus.Graph;

class DijkstraLista { // Disperse :O(V*E) Dense:// O(E Log V)
public long[] Dijkstra_Lista(int ini, ArrayList<Edge>[] list, long solve[]) {
	PriorityQueue<Integer> q = new PriorityQueue<>();
	q.add(ini); solve[ini] = 0;
	while (!q.isEmpty()) {
		int u = q.poll();
		for (int i = 0; i < list[u].size(); i++) {
			if (list[u].get(i).costo + solve[u] < solve[list[u].get(i).nodo]) {
				solve[list[u].get(i).nodo] = list[u].get(i).costo + solve[u];
				q.add(list[u].get(i).nodo);
			}
		}
	} return solve;
}
public class Edge implements Comparable<Edge> {
	public int nodo, costo;
	public Edge(int nodo, int costo) {
		this.nodo = nodo;
		this.costo = costo;
	}
	public int compareTo(Edge o) {
		return Integer.compare(this.nodo, o.nodo) == 0 ? Integer.compare(this.costo, o.costo)
		: Integer.compare(this.nodo, o.nodo);
	} } }
