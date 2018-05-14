package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Babel {
	public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String ini, fin, peso;
		String idioma1, idioma2;

		HashMap<String, ArrayList<Edge>> ady = new HashMap<>();
		StringTokenizer st;
		while (true) {

			ady.clear();
			int caso = Integer.parseInt(in.readLine().trim());

			if (caso == 0) {
				break;
			}
			st = new StringTokenizer(in.readLine());
			idioma1 = st.nextToken();
			idioma2 = st.nextToken();

			for (int i = 0; i < caso; i++) {
				st = new StringTokenizer(in.readLine());
				ini = st.nextToken();
				fin = st.nextToken();
				peso = st.nextToken();
				if (!ady.containsKey(ini)) {
					ady.put(ini, new ArrayList<>());
				}
				ady.get(ini).add(new Edge(peso.length(), peso.charAt(0), fin));
				if (!ady.containsKey(fin)) {
					ady.put(fin, new ArrayList<>());
				}
				ady.get(fin).add(new Edge(peso.length(), peso.charAt(0), ini));
			}

			// for (Entry<String,ArrayList<Edge>> a : res.entrySet()) {
			// System.out.println(a.getKey()+" "+a.getValue());
			// }

			if (!ady.containsKey(idioma1) || !ady.containsKey(idioma2)) {
				out.println("impossivel");
			} else {
				dijkstra(ady, idioma1, idioma2);
			}
		}

		out.close();
		in.close();
	}

	public static void dijkstra(HashMap<String, ArrayList<Edge>> ady, String ini, String fin) {
		HashMap<String, Long> res = new HashMap<>();
		for (Entry<String, ArrayList<Edge>> a : ady.entrySet()) {
			res.put(a.getKey(), Long.MAX_VALUE);
		}
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.add(new Vertex(ini, '*', 0));
		res.put(ini, 0L);
		while (!pq.isEmpty()) {
			Vertex u = pq.poll();
//			if(u.palabra.equals(fin)){
//				break;
//			}
			for (int i = 0; i < ady.get(u.palabra).size(); i++) {
				Edge e = ady.get(u.palabra).get(i);
				// !(u.palabra.equals(ini)) &&
				if ( u.peso + e.tam < res.get(e.dest) && u.letra != e.letra) {
					res.put(e.dest, u.peso + e.tam);
					Vertex v = new Vertex(e.dest, e.letra, u.peso + e.tam);
					v.padre = u.palabra;
					pq.add(v);
				}
			}
		}
		out.println(res.get(fin) == Long.MAX_VALUE || res.get(fin) == 0? "impossivel" : res.get(fin));
	}

	public static class Edge {
		public int tam;
		public char letra;
		public String dest;

		public Edge(int tam, char letra, String target) {
			this.tam = tam;
			this.letra = letra;
			this.dest = target;
		}

		@Override
		public String toString() {
			return tam + " " + letra + " " + dest;
		}
	}

	public static class Vertex implements Comparable<Vertex> {
		public String palabra;
		public char letra;
		public long peso;
		public String padre;

		public Vertex(String palabra, char letra, long peso) {
			this.palabra = palabra;
			this.letra = letra;
			this.peso = peso;
			padre = "*";
		}

		public int compareTo(Vertex o) {
			return Long.compare(peso, o.peso);
		}
	}
}