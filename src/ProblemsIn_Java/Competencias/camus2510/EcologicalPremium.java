package ProblemsIn_Java.Competencias.camus2510;

import java.io.*;
import java.util.*;

public class EcologicalPremium {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int t = Integer.parseInt(in.readLine());

		for (int l = 0; l < t; l++) {
			long s = Integer.parseInt(in.readLine());

			long total = 0;

			for (int i = 0; i < s; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				st.nextToken();
				int b = Integer.parseInt(st.nextToken());
				total += a * b;
			}
			out.println(total);
		}
		out.close();
	}
}
