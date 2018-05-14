package ProblemsIn_Java.LiveArchive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Powers {

	public static void main(String[] args) throws IOException {
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			long a = Long.parseLong(tec.readLine().trim());
			if (a == -1)
				break;
			long raiz = (long) Math.sqrt(a);
			long act = 0;
			long cont = 1;
			int l = 0;
			boolean b = false;
			loop: for (int i = 2; i <= raiz; i++) {
				cont = 1;
				for (act = i; act <= a; act *= i, cont++) {
					if (act == a) {
						l = i;
						b = true;
						break loop;
					}
				}
			}
			out.println(!b ? a + "^1" : l + "^" + cont);
		}
		out.close();
	}
}