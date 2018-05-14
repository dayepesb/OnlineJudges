package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BeatTheSpread {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			int a = (s + d) / 2;
			int b = s - a;

			if (a >= 0 && b >= 0 && a - b == d)
				out.println(a + " " + b);
			else
				out.println("impossible");
		}
		out.close();
		in.close();
	}
}