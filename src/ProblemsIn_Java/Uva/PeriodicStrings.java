package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author david yepes buitrago
 * @date 15-10-2017
 * @time 0.000 ms
 */
public class PeriodicStrings {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);

		int cases = in.nextInt();
		for (int i = 0; i < cases; i++) {
			String s = in.next();
			int border = getBorderkMP(s.toCharArray());
			int length = s.length();
			if(length%(length-border-1)==0)
				out.printf("%d\n", length-border-1);
			else
				 out.printf("%d\n", length);

			if (i!=(cases-1))
				out.println(i+"csadasdasd");
		}

		in.close();
		out.close();
	}

	static int getBorderkMP(char[] cadena) {
		int P[] = new int[cadena.length];
		P[0] = -1;
		int j = -1;
		for (int i = 1 ; i < cadena.length ; i++){
			while(j >= 0 && cadena[j+1] != cadena[i])
				j = P[j];
			if(cadena[j+1] == cadena[i])
				++j;
			P[i] = j;
		}
		return j;
	}

}
