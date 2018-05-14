package ProblemsIn_Java.CodeForces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class StringsOfPower {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		for (String line; (line = in.readLine()) != null;) {
			line = line.trim().toLowerCase();
			ArrayList<Integer> metal = boyerMoore("metal", line), heavy = boyerMoore("heavy", line);
			int resp = 0;
			for (Integer h : heavy) {
				for (Integer m : metal) {
					if(h<m)resp++;
				}
			}
			out.println(resp);
		}

		out.close();
		in.close();
	}

	static int D1[];

	static ArrayList<Integer> boyerMoore(String patter, String text) {
		ArrayList<Integer> bm = new ArrayList<>();

		char[] P = patter.toCharArray();
		char[] T = text.toCharArray();
		int m = P.length;
		int n = T.length;
		int offSet = 0;
		int last = m - 1;
		int maxOffSet = n - m;
		int scan = 0;
		preBoyerMoore(P, 256);
		while (offSet <= maxOffSet) {
			for (scan = last; scan > -1 && P[scan] == T[scan + offSet]; scan--) {
				if (scan == 0)
					bm.add(offSet);
			}
			offSet += D1[T[offSet + last]];
		}

		return bm;
	}

	static void preBoyerMoore(char P[], int size) {
		int m = P.length;
		D1 = new int[size];
		Arrays.fill(D1, m);
		int last = m - 1;
		for (int i = 0; i < last; i++) {
			D1[P[i]] = last - i;
		}
	}

}
