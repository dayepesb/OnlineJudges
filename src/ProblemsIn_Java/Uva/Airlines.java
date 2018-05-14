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

public class Airlines {
	private static final double Pi = 3.141592653589793;
	private static final double R = 6378;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		HashMap<String, double[]> ciu;
		HashMap<String, ArrayList<Egde>> a;
		double lalo[];
		StringTokenizer st;

		st = new StringTokenizer(in.readLine());
		int ciudades = Integer.parseInt(st.nextToken());
		int vuelos = Integer.parseInt(st.nextToken());
		int consul = Integer.parseInt(st.nextToken());

		Ciclo: for (int i = 1;; i++) {

			out.printf("Case #%d%n", i);

			ciu = new HashMap<>();
			a = new HashMap<>();

			for (int j = 0; j < ciudades; j++) {
				lalo = new double[2];
				st = new StringTokenizer(in.readLine());
				String nombre = st.nextToken();
				a.put(nombre, new ArrayList<Egde>());
				double latitud = Double.parseDouble(st.nextToken());
				double longitud = Double.parseDouble(st.nextToken());
				lalo[0] = latitud;
				lalo[1] = longitud;
				ciu.put(nombre, lalo);
			}

			for (int j = 0; j < vuelos; j++) {
				st = new StringTokenizer(in.readLine());
				String ciu1 = st.nextToken();
				ArrayList<Egde> l = new ArrayList<>();
				String ciu2 = st.nextToken();
				double uno[] = ciu.get(ciu1);
				double dos[] = ciu.get(ciu2);
				if (a.get(ciu1) != null) {
					l.addAll(a.get(ciu1));
				}
				l.add(new Egde(ciu2, distancia(uno, dos)));
				a.put(ciu1, l);
			}
			
			// for (Entry<String, ArrayList<Egde>> d : a.entrySet()) {
			// System.out.println(d.getKey()+" "+d.getValue());
			// }
			
			for (int j = 0; j < consul; j++) {
				st = new StringTokenizer(in.readLine());
				String ini = st.nextToken();
				String fin = st.nextToken();
				long d = Dijstra(a, ini, fin);
				if (d != Long.MAX_VALUE) {
					out.println(d + " km");
				} else {
					out.println("no route exists");
				}
			}

			st = new StringTokenizer(in.readLine());
			ciudades = Integer.parseInt(st.nextToken());
			vuelos = Integer.parseInt(st.nextToken());
			consul = Integer.parseInt(st.nextToken());

			if (ciudades == vuelos && vuelos == consul && consul == 0) {
				break Ciclo;
			}
			out.println();
		}

		out.close();
		in.close();
	}

	public static Long Dijstra(HashMap<String, ArrayList<Egde>> a, String ini, String fin) {
		PriorityQueue<Egde> q = new PriorityQueue<>();
		HashMap<String, Long> res = new HashMap<>();
		for (Entry<String, ArrayList<Egde>> m : a.entrySet()) {
			res.put(m.getKey(), Long.MAX_VALUE);
		}

		q.add(new Egde(ini, 0.));
		res.put(ini, 0L);
		while (!q.isEmpty()) {
			Egde u = q.poll();
			ArrayList<Egde> list = a.get(u.nombre);
			for (int i = 0; i < list.size(); i++) {
				Egde object = list.get(i);
				if (res.get(object.nombre) > (res.get(u.nombre) + object.costo)) {
					res.put(object.nombre, Math.round(res.get(u.nombre)) + Math.round(object.costo));
					q.add(new Egde(object.nombre, Math.round(object.costo)));
				}
			}

		}
		return res.get(fin);
	}

	public static double distancia(double[] uno, double[] dos) {

		double pLat = uno[0] * Pi/180;
		double pLon = uno[1] * Pi/180;
		double qLat = dos[0] * Pi/180;
		double qLon = dos[1] * Pi/180;

		double d = Math.acos(Math.cos(pLat) * Math.cos(qLat) * Math.cos(pLon - qLon) + Math.sin(pLat) * Math.sin(qLat));

		return d * R;
	}

	public static class Egde implements Comparable<Egde> {

		public String nombre;
		public double costo;

		public Egde(String nombre, double d) {
			this.nombre = nombre;
			this.costo = d;
		}

		@Override
		public int compareTo(Egde o) {
			return (Double.compare(this.costo, o.costo));
		}

		@Override
		public String toString() {
			return nombre + "   " + costo;
		}
	}
}