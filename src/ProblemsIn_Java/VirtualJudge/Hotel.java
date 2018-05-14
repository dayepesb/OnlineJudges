package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author david yepes buitrago
 * @date 01-08-2017
 * @time 0.109 ms
 */
public class Hotel {
	public static void main(String[] args) throws IOException {
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		for (String line; (line = tec.readLine()) != null;) {
			int n = Integer.parseInt(line.trim());
			int[][] mat = new int[n][n];
			int num = 1;
			int iteracion = 1;
			int a = 0, b = mat.length - 1;
			while (iteracion <= 2 * n - 1) {
				if (a >= mat.length || b >= mat.length) {
					iteracion++;
					if (iteracion <= n) {
						a = 0;
						b = n - iteracion;
					} else {
						a = iteracion - n;
						b = 0;
					}
				} else {
					mat[a++][b++] = num++;
				}
			}
			for (int i = 0; i < mat.length; i++) {
				out.print(mat[i][0]);
				for (int j = 1; j < mat.length; j++) {
					out.print(" " + mat[i][j]);
				}
				out.println();
			}

		}
		out.close();
	}
}
