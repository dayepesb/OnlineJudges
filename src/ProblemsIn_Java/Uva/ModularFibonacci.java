package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ModularFibonacci {
	public static long M[][] = { { 1, 1 }, { 1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (String line; (line = in.readLine()) != null;) {
			st = new StringTokenizer(line.trim());
			long n = Long.parseLong(st.nextToken());
			long m = Long.parseLong(st.nextToken());
			if(m == 0 || n == 0){
				out.println(0);
			}else{
				int modulo = (1 << m) - 1;
				long s[][] = res(n - 1, modulo);
				out.println(s[0][0]&modulo);
			}
		}

		out.close();
		in.close();
	}

	public static long[][] res(long n, int modulo) {
		
		long[][] res = { { 1, 0 }, { 0, 1 } };
		long pot [][] = M;
		
		String s = Long.toBinaryString(n);
		for (int i = s.length() - 1; i > -1; i--) {
			if (s.charAt(i) == '1') {
				res = matriz(res, pot, modulo);
			}
			pot = matriz(pot, pot, modulo);
		}

		return res;

	}

	public static long[][] matriz(long[][] s, long[][] l, int modulo) {
		long r[][] = new long[2][2];
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r.length; j++) {
				for (int k = 0; k < r.length; k++) {
					r[i][j] += ((s[i][k] * l[k][j]) & modulo);
				}
			}
		}
		return r;
	}

	// public static long decimalBinario(long numero) {
	// long dijito;
	// long binario = 0;
	// long exp = 0L;
	// while (numero != 0) {
	// dijito = numero & 1;
	// binario += dijito * Math.pow(10, exp);
	// exp++;
	// numero = numero >> 1;
	// }
	// return binario;
	// }
}