package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WeightedAverages {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int n = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			out.printf("%.1f%n",Double.parseDouble(st.nextToken())*2/10+Double.parseDouble(st.nextToken())*3/10+Double.parseDouble(st.nextToken())*5/10);
		}

		out.close();
		in.close();
	}
}
