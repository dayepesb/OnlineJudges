package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Puzzle_9 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		HashMap<String, String> bfs = bfs();

		for (String line; !((line = in.readLine()).equals("0"));) {

			String s = "";

			StringTokenizer st = new StringTokenizer(line);
			while (st.hasMoreTokens()) {
				s += st.nextToken();
			}
			line = in.readLine();
			st = new StringTokenizer(line);
			while (st.hasMoreTokens()) {
				s += st.nextToken();
			}
			line = in.readLine();
			st = new StringTokenizer(line);
			while (st.hasMoreTokens()) {
				s += st.nextToken();
			}
			if (bfs.containsKey(s)) {
				String l = bfs.get(s);
				out.println(l.length() / 2 + " " + l);
			} else {
				out.println("Not solvable");
			}
		}
		out.close();
		in.close();
	}

	public static HashMap<String, String> bfs() {
		String fin = "123456789";
		HashMap<String, String> map = new HashMap<>();
		Queue<String> cola = new LinkedList<>();
		cola.add(fin);
		map.put(fin, "");
		while (!cola.isEmpty()) {
			String u = cola.poll();
			for (int i = 1; i < 4; i++) {
				String ady = new String(mHor(u, i));
				if (!map.containsKey(ady)) {
					cola.add(ady);
					map.put(ady, "H" + (i) + "" + map.get(u));
				}
				ady = new String(mVer(u, i));
				if (!map.containsKey(ady)) {
					cola.add(ady);
					map.put(ady, "V" + i + "" + map.get(u));
				}
			}
		}
		return map;
	}

	public static char[] mHor(String source, int i) {
		i--;
		char [] s = source.toCharArray();
		char[] nodo = s.clone();

		nodo[i * 3] = s[i * 3 + 1];
		nodo[i * 3 + 1] = s[i * 3 + 2];
		nodo[i * 3 + 2] = s[i * 3];
		return nodo;
	}

	public static char[] mVer(String source, int i) {
		i--;

		char [] s = source.toCharArray();
		char[] nodo = s.clone();

		nodo[i] = s[i + 6];
		nodo[i + 3] = s[i];
		nodo[i + 6] = s[i + 3];

		return nodo;
	}
}