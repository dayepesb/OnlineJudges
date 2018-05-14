package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AgeSort {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new  BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int tam,c[];
		while (true) {
			st = new StringTokenizer(in.readLine());
			tam = Integer.parseInt(st.nextToken());
			if(tam==0)break;
			c = new int[tam];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < c.length; c[i] = Integer.parseInt(st.nextToken()), i++)
				;
			Arrays.sort(c);
			boolean first = true;
			StringBuilder sb = new StringBuilder();
			int n = c.length;
			for (int i = 0; i < n; i++) {
				if (!first) {
					sb.append(" ");
				}
				sb.append(c[i]);
				first = false;
			}
			out.println(sb.toString());
		}
		out.close();
		in.close();
	}
}
