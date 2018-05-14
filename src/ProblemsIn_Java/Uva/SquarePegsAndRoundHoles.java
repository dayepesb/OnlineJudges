package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class SquarePegsAndRoundHoles {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		String line;
		int r;
		boolean l = false;
		for (; (line = in.readLine()) != null;) {
			r = Integer.parseInt(line.trim());
			if (l) {
				out.println();
			}
			int res[] = geometria(r);
			out.printf("In the case n = %d, %d cells contain segments of the circle.%n",r,res[0]);
			out.printf("There are %d cells completely contained in the circle.%n",res[1]);
			l = true;
		}

		out.close();
		in.close();
	}

	public static int[] geometria(int n) {
		int res[] = new int[2], seg = 0, ins = 0;
		double radio = (n - 0.5) * (n - 0.5);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (distancia(i, j, n) < radio) {
					ins++;
				} else if (distancia(i + 1, j + 1, n) <= radio) {
					seg++;
				}
			}
		}
		seg *= 4;
		ins *= 4;
		res[0] = seg;
		res[1] = ins;
		return res;
	}

	public static double distancia(int i, int j, int n) {
		return ((i - n) * (i - n) + (j - n) * (j - n));
	}
}
