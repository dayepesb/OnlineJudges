package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bicoloring {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		Ciclo: while (true) {
			long nodos = Long.parseLong(in.readLine().trim());
			if (nodos == 0) {
				break Ciclo;
			} else {
				boolean mAdy[][] = new boolean[(int) nodos][(int) nodos];
				int colores[] = new int[(int) nodos];
				long arcos = Long.parseLong(in.readLine().trim());
				for (int i = 0; i < arcos; i++) {
					StringTokenizer st = new StringTokenizer(in.readLine().trim(), " ");
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					mAdy[x][y] = true;
					mAdy[y][x] = true;
				}
				boolean sePuede = pintar(mAdy, colores, 1);
				if (sePuede) {
					out.write("BICOLORABLE.".trim() + "\n");
				} else {
					out.write("NOT BICOLORABLE.".trim() + "\n");
				}
			}
		}
		out.close();
		in.close();
	}

	public static boolean pintar(boolean mAdy[][], int colores[], int color) {
		Queue<Integer> cola = new LinkedList<>();
		cola.add(0);
		if (colores[0] == 0) {
			colores[0] = color;
		} else {
			return false;
		}
		while (!cola.isEmpty()) {
			int u = cola.poll();
			if (colores[u] == 1) {
				color = 2;
			} else {
				color = 1;
			}
			for (int i = 0; i < mAdy[u].length; i++) {
				if (mAdy[u][i]) {
					if (colores[i] != 0) {
						if (colores[i] != color) {
							return false;
						}
					} else {
						colores[i] = color;
						cola.add(i);
					}
				}
			}
		}
		return true;
	}
	
}
