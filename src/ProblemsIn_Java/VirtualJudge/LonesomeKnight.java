package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author david yepes buitrago
 * @date 01-08-2017
 * @time 0.062 ms
 */
public class LonesomeKnight {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int casos = Integer.parseInt(in.readLine().trim());
		for (int c = 0; c < casos; c++) {
			String a = in.readLine().trim();
			int fil = (int) a.charAt(0) - 96;
			int col = Integer.parseInt(a.charAt(1) + "");
			int res = 0;
			if (fil - 2 > 0 && col - 1 > 0)
				res++;
			if (fil - 1 > 0 && col - 2 > 0)
				res++;
			if (fil + 1 <= 8 && col - 2 > 0)
				res++;
			if (fil + 2 <= 8 && col - 1 > 0)
				res++;
			if (fil - 2 > 0 && col + 1 <= 8)
				res++;
			if (fil - 1 > 0 && col + 2 <= 8)
				res++;
			if (fil + 1 <= 8 && col + 2 <= 8)
				res++;
			if (fil + 2 <= 8 && col + 1 <= 8)
				res++;
			out.println(res);
		}

		out.close();
		in.close();
	}
}
