package ProblemsIn_Java.Competencias.Camus20171101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class CountThesePermutations {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);

		long mod = 1000000007;
		long factorial[] = new long[1000002];
		long solution[] = new long[1000002];
		factorial[0] = 1;
		for (int i = 1; i < factorial.length; i++) {
			factorial[i] = (factorial[i-1]*i)%mod;
			if (i%2==0) {
				solution[i] = (factorial[i/2]*factorial[i/2]%mod);
			} else {
				solution[i] = (factorial[(i-1)/2]*factorial[(i-1)/2]%mod*i%mod);
			}
		}

		while(in.hasNext()) {
			out.println(solution[in.nextInt()]);
		}

		out.close();
		in.close();
	}
}
