package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Friends {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int casos = Integer.parseInt(in.readLine().trim());
		for (int k = 0; k < casos; k++) {
			st = new StringTokenizer(in.readLine());
			int ciudadanos = Integer.parseInt(st.nextToken());
			int amigos = Integer.parseInt(st.nextToken());
			int conjunto[] = new int[ciudadanos];
			Arrays.fill(conjunto, -1);
			for (int i = 0; i < amigos; i++) {
				st = new StringTokenizer(in.readLine());
				conjunto = union(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, conjunto);
			}
			int max = -1;
			for (int i = 0; i < conjunto.length; i++) {
				max = Math.max(max, conjunto[i] * -1);
			}
			out.println(max);
		}

		out.close();
		in.close();
	}

	public static int[] union(int a, int b, int[] conjunto) {
		a = find(a, conjunto);
		b = find(b, conjunto);

		if (a == b)
			return conjunto;

		int tamX = conjunto[a] * -1;
		int tamY = conjunto[b] * -1;

		if (tamX < tamY) {
			conjunto[b] = conjunto[b] + conjunto[a];
			conjunto[a] = b;
		} else {
			conjunto[a] = conjunto[a] + conjunto[b];
			conjunto[b] = a;
		}

		return conjunto;
	}

	public static int find(int x, int[] conjunto) {
		if (conjunto[x] < 0)
			return x;
		else
			return conjunto[x] = find(conjunto[x], conjunto);
	}
}
