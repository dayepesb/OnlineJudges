package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class VitosFamily {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int casos = Integer.parseInt(in.readLine().trim());

		for (int i = 0; i < casos; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int[] a = new int[st.countTokens() - 1];
			st.nextToken();
			for (int j = 0; j < a.length; j++) {
				a[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(a);
			int m = a[a.length / 2];
			int t = 0;
			for (int j = 0; j < a.length; j++) {
				t += Math.abs(a[j] - m);
			}
			out.println(t);
		}

		out.close();
		in.close();
	}

}
