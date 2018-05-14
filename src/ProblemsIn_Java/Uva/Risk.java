package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Risk {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int caso = 1;
		for (String line; (line = in.readLine()) != null;) {
			boolean[][] mady = new boolean[21][21];
			st = new StringTokenizer(line);
			st.nextToken();
			while (st.hasMoreTokens()) {
				int b = Integer.parseInt(st.nextToken());
				mady[b][1] = true;
				mady[1][b] = true;
			}
			for (int i = 2; i < 20; i++) {
				line = in.readLine();
				st = new StringTokenizer(line);
				st.nextToken();
				while (st.hasMoreTokens()) {
					int b = Integer.parseInt(st.nextToken());
					mady[b][i] = true;
					mady[i][b] = true;
				}
			}
			out.println("Test Set #" + caso++);
			int aris = Integer.parseInt(in.readLine().trim());
			for (int ppp = 0; ppp < aris; ppp++) {
				line = in.readLine();
				st = new StringTokenizer(line);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				out.printf("%2d to %2d:%2d%n", a, b, bfs(mady, a, b));
			}
			out.println();
		}

		out.close();
		in.close();
	}

	public static int bfs(boolean mAdy[][], int ini, int fin) {
		int visit[] = new int[21];

		Queue<Integer> cola = new LinkedList<>();
		cola.add(ini);
		visit[ini] = 1;
		while (!cola.isEmpty()) {
			int v = cola.poll();
			for (int i = 1; i < mAdy[v].length; i++) {
				if (mAdy[v][i]) {
					if (i == fin) {
						return visit[v];
					} else if (visit[i] == 0) {
						visit[i] = visit[v] + 1;
						cola.add(i);
					}

				}
			}
		}
		return 0;
	}
}
