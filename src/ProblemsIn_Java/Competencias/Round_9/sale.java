package ProblemsIn_Java.Competencias.Round_9;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class sale {
	static long[][] mat;
	static int[][] prec;

	public static void main(String[] args) throws IOException {
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int casos = Integer.parseInt(tec.readLine().trim());
		for (int caso = 0; caso < casos; caso++) {
			int n = Integer.parseInt(tec.readLine().trim());
			prec = new int[n][];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(tec.readLine());
				prec[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			}
			int[] ms = new int[Integer.parseInt(tec.readLine().trim())];
			for (int i = 0; i < ms.length; i++)
				ms[i] = Integer.parseInt(tec.readLine().trim());
			mat = new long[31][n+1];
			long suma = 0;
			for (int i = 0; i < ms.length; i++) 
				suma += res(ms[i], n);			
			out.println(suma);
		}
		out.close();
	}

	private static long res(int c, int i) {
		if (mat[c][i] != 0)
			return mat[c][i];
		if (i == 0)
			return 0;
		if (i > 0 && prec[i - 1][1] > c)
			return mat[c][i] = res(c, i - 1);
		if (i > 0 && prec[i - 1][1] <= c)
			return mat[c][i] = Math.max(res(c, i - 1), res(c - prec[i - 1][1], i - 1) + prec[i - 1][0]);
		return 0;
	}
}