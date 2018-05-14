package ProblemsIn_Java.COJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FractionalLotion {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		for (String line = in.readLine(); line != null; line = in.readLine()) {
			StringTokenizer st = new StringTokenizer(line, "/");
			st.nextToken();
			int n = Integer.parseInt(st.nextToken());
			int count = 0;
			for (int i = n + 1; i <= 2 * n; i++) {
				if ((i * n) % (i - n) == 0)
					count++;
			}
			out.println(count);
		}

		out.close();
		in.close();
	}

}
