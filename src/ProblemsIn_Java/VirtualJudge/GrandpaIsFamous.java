package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author David Yepes Buitrago
 *
 * @Date 29-07-2017
 */
public class GrandpaIsFamous {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int n, m;
		for (String line; !(line = in.readLine().trim()).equals("0 0");) {
			st = new StringTokenizer(line);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int[] array = new int[10001];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < m; j++) {
					array[Integer.parseInt(st.nextToken())]++;
				}
			}
			int max = -1;
			for (int i : array) {
				max = Math.max(max, i);
			}
			int maxAux = -1;
			for (int i : array) {
				if (i != max) {
					maxAux = Math.max(maxAux, i);
				}
			}
			for (int i = 1; i < array.length; i++) {
				if (array[i] == maxAux) {
					out.print(i + " ");
				}
			}
			out.println();
		}

		in.close();
		out.close();
	}
}
