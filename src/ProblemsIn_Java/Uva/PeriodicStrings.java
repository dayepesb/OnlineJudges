package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author david yepes buitrago
 * @date 15-10-2017
 * @time 0.000 ms
 */
public class PeriodicStrings {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);

		int tc = in.nextInt();
		for (int i = 0; i < tc; i++) {
			String s = in.next();
			int [] border = getBorderkMP(s.toCharArray());
			for (int j = 0; j < border.length; j++) {
				int t = border.length-1;
				int k = t-border[j];
				if(t%k==0) {
					out.println(t/4);
					break;
				}
			}

		}

		in.close();
		out.close();
	}

	static int[] getBorderkMP(char[] cadena) {
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
