package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;
/**
 * 
 * @author David Yepes
 * Acepted
 * Time :  0.090 s
 * date :  15/12/2016
 *
 */
public class Y_Game {

	static boolean[][][] mAdy, visit;
	static int nodos, aristas;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int x, y, z;
		StringTokenizer st;
		ArrayList<nodo> ady;
		while (true) {
			st = new StringTokenizer(in.readLine());
			nodos = Integer.parseInt(st.nextToken());
			aristas = Integer.parseInt(st.nextToken());

			if (nodos == aristas && aristas == 0)
				break;

			mAdy = new boolean[nodos + 1][nodos + 1][nodos + 1];
			visit = new boolean[nodos + 1][nodos + 1][nodos + 1];
			ady = new ArrayList<>();

			for (int i = 0; i < aristas; i++) {
				st = new StringTokenizer(in.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				z = Integer.parseInt(st.nextToken());
				mAdy[x][y][z] = true;
				ady.add(new nodo(x, y, z));
			}

			boolean res = false;

			for (int i = 0; i < ady.size(); i++) {
				nodo n = ady.get(i);
				if (!visit[n.x][n.y][n.z]) {
					res = bfs(n);
					if (res)
						break;
				}
			}
			out.println(res ? "Benny" : "Willy");

		}

		out.close();
		in.close();
	}


	public static boolean bfs(nodo n) {

		Deque<nodo> q = new ArrayDeque<>();
		boolean pos[] = new boolean[3];
		visit[n.x][n.y][n.z] = true;
		q.add(n);
		while (!q.isEmpty()) {
			nodo u = q.poll();
			if (u.x == 0)
				pos[0] = true;
			if (u.y == 0)
				pos[1] = true;
			if (u.z == 0)
				pos[2] = true;

			ArrayList<nodo> mov = mov(u);
			for (nodo v : mov) {
				if (mAdy[v.x][v.y][v.z] && !visit[v.x][v.y][v.z]) {
					visit[v.x][v.y][v.z] = true;
					q.add(v);
				}
			}

			if (pos[0] && pos[1] && pos[2])
				return true;
		}

		return false;
	}

	public static ArrayList<nodo> mov(nodo u) {
		int x, y, z;
		ArrayList<nodo> m = new ArrayList<>();
		x = u.x;
		y = u.y;
		z = u.z;

		if (x - 1 >= 0 && z + 1 <= nodos && ((x - 1) + y + (z + 1)) == nodos) {
			m.add(new nodo(x - 1, y, z + 1));
		}
		if (y - 1 >= 0 && z + 1 <= nodos && ((y - 1) + x + (z + 1)) == nodos) {
			m.add(new nodo(x, y - 1, z + 1));
		}
		if (x + 1 <= nodos && y - 1 >= 0 && ((x + 1) + z + (y - 1)) == nodos) {
			m.add(new nodo(x + 1, y - 1, z));
		}
		if (x + 1 <= nodos && z - 1 >= 0 && ((x + 1) + y + (z - 1)) == nodos) {
			m.add(new nodo(x + 1, y, z - 1));
		}
		if (y + 1 <= nodos && z - 1 >= 0 && ((y + 1) + x + (z - 1)) == nodos) {
			m.add(new nodo(x, y + 1, z - 1));
		}
		if (x - 1 >= 0 && y + 1 <= nodos && ((x - 1) + z + (y + 1)) == nodos) {
			m.add(new nodo(x - 1, y + 1, z));
		}

		return m;
	}

	static class nodo {
		public int x, y, z;

		public nodo(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
