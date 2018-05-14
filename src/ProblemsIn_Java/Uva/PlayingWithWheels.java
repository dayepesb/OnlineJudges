package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PlayingWithWheels {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int casos = Integer.parseInt(in.readLine().trim());

		for (int i = 0; i < casos; i++) {

			in.readLine();

			StringTokenizer st;
			st = new StringTokenizer(in.readLine().trim(), " ");
			int origen = Integer.parseInt(st.nextToken() + "" + st.nextToken() + "" + st.nextToken() + "" + st.nextToken());
			st = new StringTokenizer(in.readLine().trim(), " ");
			int fin = Integer.parseInt(st.nextToken() + "" + st.nextToken() + "" + st.nextToken() + "" + st.nextToken());

			int[] visit = new int[10000];

			int cPro = Integer.parseInt(in.readLine().trim()); 
			 
			for (int k = 0; k < cPro; k++) { 
				st = new StringTokenizer(in.readLine().trim(), " ");
				String a = st.nextToken();
				String b = st.nextToken();
				String c = st.nextToken();
				String d = st.nextToken();
				int pos = Integer.parseInt(a + "" + b + "" + c + "" + d + "");
				visit[pos] = -1;
			}
			out.println(bfs(visit, origen, fin));
		}

		out.close();
		in.close();
	}

	public static int bfs(int visit[], int origen, int fin) {

		Queue<Integer> cola = new LinkedList<>();
		cola.add(origen);
		visit[origen] = 1;
		while (!cola.isEmpty()) {
			int v = cola.poll();
			if (v == fin) {
				return visit[v] - 1;
			}
			// dividirlo por cifras
			int n1 = (v / 1000);
			int n2 = (v / 100) % 10;
			int n3 = (v / 10) % 10;
			int n4 = v % 10;
			int ady[] = mov(n1, n2, n3, n4);
			for (int i = 0; i < ady.length; i++) {
				if (visit[ady[i]] == 0) {
					visit[ady[i]] = visit[v] + 1;
					cola.add(ady[i]);
				}
			}
		}
		return -1;
	}

	public static int[] mov(int n1, int n2, int n3, int n4) {
		int cont = 0;
		int[] ady = new int[8];
		int[] nums = { n1, n2, n3, n4 };
		int[] n = nums.clone();
		for (int i = 0; i < nums.length; i++) {
			for (int j = -1; j < 3; j += 3) {
				String a = "";
				if (nums[i] + j == -1) {
					nums[i] = 9;
				} else {
					if (nums[i] + j == 10) {
						nums[i] = 0;
					} else {
						if (nums[i] + j == 11) {
							nums[i] = 1;
						} else {
							nums[i] = nums[i] + j;
						}
					}
				}

				for (int k = 0; k < nums.length; k++) {
					a += "" + nums[k];
				}
				ady[cont++] = Integer.parseInt(a);
			}
			nums[i] = n[i];
		}
		return ady;
	}
}
