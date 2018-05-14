package ProblemsIn_Java.Notebook_Camus.DataStrutures;

class UnionFind {
	//Recordar que para el conjunto inicial que son los padres de cada uno esten
	//rellenos con -1 que indica que ellos son los lideren de su propia componente.
	int set[];
	void union(int x, int y) {
		x = find(x); y = find(y);
		if (x == y) return;
		int sizex = -(set[x]); int sizey = -(set[y]);
		if (sizex < sizey) { set[y] = set[y] + set[x]; set[x] = y;}
		else { set[x] = set[x] + set[y]; set[y] = x;}
	}
	// Busca el padre o nodo raiz en este arbol
	int find(int x) {
		if (set[x] < 0) return x;
		else return set[x] = find(set[x]);
	}
}
