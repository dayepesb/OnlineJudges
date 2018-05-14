package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class MonitorinTheAmazon {
	
	static class Punto implements Comparable<Punto>{
		
		int x,y;
		
		public Punto(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Punto that) {
			if (this.x < that.x) {
				return -1;
			} else if (this.x > that.x) {
				return 1;
			} else {
				// desempatar por la coordenada y
				if (this.y < that.y) {
					return -1;
				} else if (this.y > that.y) {
					return 1;
				}
			}
			return 0;
		}
		
		public String toString() {
			return String.format("(%d,%d)", x, y);
		}
		
	}

	public static void main(String[] args) throws IOException {
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int n; (n = Integer.parseInt(in.readLine().trim())) != 0; ) {
			StringTokenizer stk = new StringTokenizer(in.readLine().trim());
			Punto[] puntos = new Punto[n];
			for (int i=0; i<n; i++) {
				int x = Integer.parseInt(stk.nextToken());
				int y = Integer.parseInt(stk.nextToken());
				puntos[i] = new Punto(x, y);
			}
			int[][] lAdy = new int[n][2];
			
			for (int i=0; i<n; i++) { // por cada punto i
				// buscar al mas cercano
				int index = -1;// indice del punto m�s cercano
				int disMin = Integer.MAX_VALUE;
				for (int j=0; j<n; j++) { // por cada uno de los demas puntos
					if (j != i) {
						int dis = distancia2(puntos[i], puntos[j]);
						
						
						if ((dis < disMin) || 
								(dis == disMin && puntos[j].compareTo(puntos[index])<0)) {
							index = j;
							disMin = dis;
						}
					}
				}
				lAdy[i][0] = index;
				// buscar al segundo mas cercano
				int index2 = -1;
				int disMin2 = Integer.MAX_VALUE;
				for (int j=0; j<n; j++) { // por cada uno de los demas puntos
					if (j != i && j!=index) {
						int dis = distancia2(puntos[i], puntos[j]);
						if (dis < disMin2) {
							index2 = j;
							disMin2 = dis;
						} else if (dis == disMin2) {
							if (puntos[j].compareTo(puntos[index2])<0) {
								index2 = j;
								disMin2 = dis;
							}
						}
					}
				}
				lAdy[i][1] = index2;
			}
			for (int [] a : lAdy) {
				// System.out.println(Arrays.toString(a));
			}
			boolean visited[] = new boolean[n];
			dfs(0, lAdy, visited);
			// System.out.println(Arrays.toString(visited));
			boolean estanTodosVisitados = true;
			for (boolean b : visited) if (!b) estanTodosVisitados = false;
			System.out.println(estanTodosVisitados ? "All stations are reachable." : "There are stations that are unreachable.");
			
		}
	}
	
	private static int distancia2(Punto p, Punto q) {
		return (p.x-q.x)*(p.x-q.x) + (p.y-q.y)*(p.y-q.y);
	}

	public static void dfs(int v, int[][] lAdy, boolean[] visited) {
		int n = lAdy.length;
		visited[v] = true;
		for (int u : lAdy[v]) {
			if (visited[u]) {
			} else {
				dfs(u, lAdy, visited);
			}
		}
	}

}