package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Cacho {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;

		int casos = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < casos; i++) {
			st = new StringTokenizer(in.readLine());
			int ant = Integer.parseInt(st.nextToken());
			int act = Integer.parseInt(st.nextToken());
			boolean a = true;
			while (st.hasMoreTokens()) {
				if (ant == (act - 1)) {
					ant = act;
					act = Integer.parseInt(st.nextToken());
				} else {
					a = false;
					break;
				}
			}
			out.println(a ? "Y" : "N");
		}
		out.close();
		in.close();
	}
}
