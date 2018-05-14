package ProblemsIn_Java.SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author David Yepes Buitrago
 *
 * @Date 13-07-2017
 */
public class Period {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int casos = Integer.parseInt(in.readLine().trim());
		for (int c = 0; c < casos; c++) {
			out.printf("Test case #%d%n", c + 1);

			int n = Integer.parseInt(in.readLine().trim());
			int borde [] = borde(in.readLine().toCharArray());
			for (int i = 2; i < borde.length; i++) {
				int t = i;
				int k = t-borde[t];
				if(t%k==0&&t/k>1){
					out.printf("%d %d%n",t,t/k);
				}
			}

			out.println();
		}

		in.close();
		out.close();
	}

	static int[] borde(char[] cadena) {
		int[] T = new int[cadena.length + 1];
		T[0] = -1;
		T[1] = 0;
		for (int i = 2, j = 0; i <= cadena.length;) {
			if (cadena[i - 1] == cadena[j])
				T[i++] = ++j;
			else if (j > 0)
				j = T[j];
			else
				T[i++] = 0;
		}
		return T;
	}
}
