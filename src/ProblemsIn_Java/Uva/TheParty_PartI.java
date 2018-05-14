package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TheParty_PartI {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		int cases = Integer.parseInt(in.readLine());
		for (int i = 0; i < cases; i++) {
			in.readLine();
			StringTokenizer st = new StringTokenizer(in.readLine());
			int nodes = Integer.parseInt(st.nextToken());
			boolean[][] mAdy = new boolean[nodes][nodes];
			int aris = Integer.parseInt(st.nextToken());
			for (int j = 0; j < aris; j++) {
				st = new StringTokenizer(in.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				mAdy[a][b] = true;
				mAdy[b][a] = true;
			}

			int visit[] = array(mAdy, nodes);

			for (int j = 1; j < visit.length; j++) {
				out.println(visit[j]);
			}
			if (i < cases - 1) {
				out.println();
			}
		}
		out.close();
	}

	public static int[] array(boolean mAdy[][], int nodes) {
		int visit[] = new int[nodes];

		for (int l = 0; l < visit.length; l++) {
			visit[l] = -1;
		}

		Queue<Integer> cola = new LinkedList<>();
		cola.add(0);
		visit[0] = 0;
		while (!cola.isEmpty()) {
			int v = cola.poll();
			for (int l = 0; l < mAdy[v].length; l++) {
				if (mAdy[v][l]) {
					if (visit[l] == -1) {
						visit[l] = visit[v] + 1;
						cola.add(l);
					}
				}
			}
		}
		return visit;
	}
}