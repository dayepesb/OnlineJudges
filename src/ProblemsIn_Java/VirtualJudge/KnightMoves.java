package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author David Yepes Buitrago
 *
 * @Date 29-07-2017
 */
public class KnightMoves {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		String ini, fin;
		for (String line; (line = in.readLine()) != null;) {
			st = new StringTokenizer(line);
			ini = st.nextToken();
			fin = st.nextToken();
			String init = ini.replace("a", "1").replace("b", "2").replace("c", "3").replace("d", "4").replace("e", "5")
					.replace("f", "6").replace("g", "7").replace("h", "8");
			String finish = fin.replace("a", "1").replace("b", "2").replace("c", "3").replace("d", "4")
					.replace("e", "5").replace("f", "6").replace("g", "7").replace("h", "8");
			out.printf("To get from %s to %s takes %d knight moves.%n", ini, fin, bfs(init, finish));
		}

		in.close();
		out.close();
	}

	/**
	 * @param init
	 * @param finish
	 * @return
	 */
	static int bfs(String init, String finish) {
		int ini = Integer.parseInt(init);
		int fin = Integer.parseInt(finish);

		int x1 = ((ini / 10) % 10) - 1;
		int x2 = ((ini % 10)) - 1;
		int y1 = ((fin / 10) % 10) - 1;
		int y2 = ((fin % 10)) - 1;
		fin = Integer.parseInt(y1 + "" + y2);
		int mAdy[][] = new int[8][8];

		for (int i = 0; i < mAdy.length; i++) {
			for (int j = 0; j < mAdy[i].length; j++) {
				mAdy[i][j] = -1;
			}
		}

		Queue<Integer> cola = new LinkedList<>();
		int u = Integer.parseInt(x1 + "" + x2);
		cola.add(u);
		mAdy[x1][x2] = 0;
		while (!cola.isEmpty()) {
			int v = cola.poll();
			x1 = ((v / 10) % 10);
			x2 = ((v % 10));
			if (v == fin) {
				return mAdy[x1][x2];
			}
			LinkedList<Integer> adys = adys(x1, x2);
			for (int i = 0; i < adys.size(); i++) {
				int z1 = ((adys.get(i) / 10) % 10);
				int z2 = ((adys.get(i) % 10));

				if (adys.get(i) == fin) {
					return mAdy[x1][x2] + 1;
				} else if (mAdy[z1][z2] == -1) {
					mAdy[z1][z2] = mAdy[x1][x2] + 1;
					cola.add(Integer.parseInt(z1 + "" + z2));
				}
			}
		}

		return -1;

	}

	static LinkedList<Integer> adys(int x1, int x2) {
		LinkedList<Integer> ady = new LinkedList<>();

		if (x1 + 2 < 8 && x2 - 1 > -1) {
			ady.add(Integer.parseInt((x1 + 2) + "" + (x2 - 1)));
		}
		if (x1 + 1 < 8 && x2 - 2 > -1) {
			ady.add(Integer.parseInt((x1 + 1) + "" + (x2 - 2)));
		}
		if (x1 - 1 > -1 && x2 - 2 > -1) {
			ady.add(Integer.parseInt((x1 - 1) + "" + (x2 - 2)));
		}
		if (x1 - 2 > -1 && x2 - 1 > -1) {
			ady.add(Integer.parseInt((x1 - 2) + "" + (x2 - 1)));
		}
		if (x1 - 2 > -1 && x2 + 1 < 8) {
			ady.add(Integer.parseInt((x1 - 2) + "" + (x2 + 1)));
		}
		if (x1 - 1 > -1 && x2 + 2 < 8) {
			ady.add(Integer.parseInt((x1 - 1) + "" + (x2 + 2)));
		}
		if (x1 + 1 < 8 && x2 + 2 < 8) {
			ady.add(Integer.parseInt((x1 + 1) + "" + (x2 + 2)));
		}
		if (x1 + 2 < 8 && x2 + 1 < 8) {
			ady.add(Integer.parseInt((x1 + 2) + "" + (x2 + 1)));
		}
		return ady;
	}
}
