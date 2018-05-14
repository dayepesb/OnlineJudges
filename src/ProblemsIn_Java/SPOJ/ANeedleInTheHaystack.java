package ProblemsIn_Java.SPOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class ANeedleInTheHaystack {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		String P, T;
		for (String line; (line = in.readLine()) != null;) {
			int n = Integer.parseInt(line.trim());
			P = in.readLine().trim();
			T = in.readLine().trim();
			ArrayList<Integer> sol=boyerMooreHorspool(T, P, 256);
			if(sol.size()==0)out.println();
			else {
				for (Integer i : sol) {
					out.println(i);
				}
			}
		}

		out.close();
		in.close();
	}

	static int[] D1;

	static ArrayList<Integer> boyerMooreHorspool(String text, String pattern, int size) {

		ArrayList<Integer> resp = new ArrayList<>();
		char P[] = pattern.trim().toCharArray();
		char T[] = text.trim().toCharArray();
		int offSet = 0;
		int scan = 0;
		int last = P.length - 1;
		int maxOffSet = T.length - P.length;
		preBoyerMooreSuffixBad(P, size);

		while (offSet <= maxOffSet) {
			for (scan = last; P[scan] == T[scan + offSet]; scan--) {
				if (scan == 0)
					resp.add(offSet);
				if(scan==0)break;
			}
			offSet += D1[T[offSet + last]];
		}

		return resp;

	}

	static void preBoyerMooreSuffixBad(char P[], int size) {
		int m = P.length;
		int last = m - 1;
		D1 = new int[size];
		Arrays.fill(D1, m);
		for (int i = 0; i < last; i++) {
			D1[P[i]] = last - i;
		}
	}
}
