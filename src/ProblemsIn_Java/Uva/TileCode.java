package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class TileCode {
	public static int n[] = new int[31];
	public static int s[] = new int[31];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		n[1] = 1;
		n[2] = 3;
		s[1] = 1;
		s[2] = 3;
		s[3] = 1;
		s[4] = 5;
		
		int res [] = new int [31];
		
		for (int i = 3; i < res.length; i++) {
			res[i] = (N(i)+S(i))/2;
		}

		int casos = Integer.parseInt(in.readLine());
		for (int i = 0; i < casos; i++) {
			int a = Integer.parseInt(in.readLine());
			out.println(res[a]);
		}

		out.close();
		in.close();
	}

	public static int N(int r) {
		if (r <= 2) {
			return n[r];
		}
		return N(r - 1) + 2 * N(r - 2);
	}

	public static int S(int n) {
		if (n <= 4) {
			return s[n];
		}
		return S(n - 2) + 2 * S(n - 4);
	}
}
