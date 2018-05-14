package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheMonkeyAndOiledBamboo {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int casos = Integer.parseInt(in.readLine().trim());
		for (int caso = 1; caso <= casos; caso++) {
			int n = Integer.parseInt(in.readLine().trim());
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < arr.length; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			out.print("Case " + caso + ": ");
			if (n == 1)
				out.println(arr[0]);
			else {
				out.println(busqueda(arr));
			}
		}
		out.close();
	}

	private static int busqueda(int[] arr) {
		int a = arr[0];
		int b = arr[arr.length - 1];
		int m = arr[(arr.length - 1) / 2];
		while (Math.abs(a - b) > 1) {
			if (prueba(arr, m)) {
				b = m;
				m = (a + b) / 2;
			} else {
				a = m;
				m = (a + b) / 2;
			}
		}
		if (prueba(arr, m))
			return m;
		return m + 1;
	}

	private static boolean prueba(int[] arr, int m) {
		if (arr.length >= 1)
			if (arr[0] == m)
				m--;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] - arr[i] > m)
				return false;
			if (arr[i + 1] - arr[i] == m)
				m--;
		}
		return true;
	}
}
