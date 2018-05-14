package ProblemsIn_Java.Notebook_Camus.Graph;

class BellmanFord{ // O(V*E)
	public boolean bellmanFordSimple(ArrayList<EdgeF>[] ady, int nodos, int aristas) {
		int solve[] = new int[nodos]; String padres[] = new String[nodos];
		for (int i = 0; i < padres.length; i++) {
			solve[i] = Integer.MAX_VALUE; padres[i] = "*"; }
		int nodoIni = 0; solve[nodoIni] = 0;
		boolean hayCambios = true;
		for (int padre = 0; padre < padres.length && hayCambios; padre++) {
			hayCambios = false;
			for (EdgeF e : ady[padre]) {
				if (solve[e.dest] > solve[padre] + e.peso) {
				solve[e.dest] = solve[padre] + e.peso; padres[e.dest] = padre + ",";
				hayCambios = true;}
			} }
		return hayCambios;
	}
	class EdgeF {
		int dest; int peso;
			EdgeF(int dest, int peso) {
			this.peso = peso; this.dest = dest; }
	} }