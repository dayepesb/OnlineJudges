package ProblemsIn_Java.Notebook_Camus.Graph;

class PrimPQ { // O(V+E)
public ArrayList<edge> lAdy[];
public boolean[][] primPQ() {
	boolean visit[] = new boolean[lAdy.length];
	PriorityQueue<edge> pq = new PriorityQueue<>();
	boolean res[][] = new boolean[lAdy.length][lAdy.length];
	pq.addAll(lAdy[0]);
	while (!pq.isEmpty()) {
		edge v = pq.poll();
		if (!visit[v.end]) {
			visit[v.start] = true; visit[v.end] = true;
			res[v.start][v.end] = res[v.end][v.start] = true;
			pq.addAll(lAdy[v.end]); } } return res;
} 
class edge implements Comparable<edge> {
	int start, end, with;
	public edge(int start, int end, int with) {
		this.start = start; this.end = end; this.with = with; }
	public int compareTo(edge b) {
		return Integer.compare(this.with, b.with); }
	public String toString() {
		return (this.start) + "," + (this.end) + "," + this.with; } } }
