package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 01-08-2017
 * @time 0.234 ms
 */
public class ScientificConference {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		ArrayList<pair> events;
		StringTokenizer st;
		for (String line; (line = in.readLine()) != null;) {
			int reports = Integer.parseInt(line.trim());
			events = new ArrayList<>();
			for (int i = 0; i < reports; i++) {
				st = new StringTokenizer(in.readLine());
				events.add(new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) + 1));
			}
			Collections.sort(events);
			// separadas por un minuto
			// int inicioAct=0;
			int finAct = 0;
			int res = 0;
			for (pair p : events) {
				if (p.inicio - finAct >= 0) {
					// System.out.println(p);
					// inicioAct=p.inicio;
					finAct = p.fin;
					res++;
				}
			}
			out.println(res);
		}

		out.close();
		in.close();
	}

	static class pair implements Comparable<pair> {
		int inicio, fin;

		public pair(int inicio, int fin) {
			this.inicio = inicio;
			this.fin = fin;
		}

		@Override
		public int compareTo(pair o) {
			return Integer.compare(this.fin, o.fin);
		}

		@Override
		public String toString() {
			return String.format("inicio : %d --- fin : %d ", inicio, fin);
		}
	}
}
