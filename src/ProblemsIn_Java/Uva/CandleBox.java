package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CandleBox {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int D, R, T;
		String line;
		while ((line = in.readLine()) != null) {
			D = Integer.parseInt(line);
			R = Integer.parseInt(in.readLine());
			T = Integer.parseInt(in.readLine());
			int x = 0, y = 0;
			int a = 0, b = 0;
			while (true) {
				x++;
				if (x >= 4)
					a += x;
				if (x - y > D) {
					y++;
					if (y >= 3)
						b += y;
				}
				if (a + b == R + T)
					break;
			}
			out.printf("%d\n", R - a);
		}

		out.close();
		in.close();
	}
}
