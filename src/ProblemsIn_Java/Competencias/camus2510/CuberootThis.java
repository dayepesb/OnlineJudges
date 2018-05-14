package ProblemsIn_Java.Competencias.camus2510;

import java.io.*;
import java.util.*;

public class CuberootThis {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int[] cubos = new int[1001];
		for (int i = 0; i < cubos.length; i++)
			cubos[i] = i * i * i;

		while (true) {
			String s = in.readLine();
			if (s == null)
				break;
			StringTokenizer st = new StringTokenizer(s);

			int a = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			int mod = a % p;

			TreeSet<Integer> list = new TreeSet<>();

			for (int i = 0; i < p; i++)
				if (cubos[i] % p == mod)
					list.add(i);
			int c = list.size() == 0 ? 0 : list.last();
			for (Integer i : list)
				out.print(i + (i == c ? "" : " "));
			out.println();
		}

		out.close();
	}
}
