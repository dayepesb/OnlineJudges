package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HashmatTheBraveWarrior {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		for (String line; (line = in.readLine()) != null;) {
			st = new StringTokenizer(line);
			out.println(Math.abs(Long.parseLong(st.nextToken()) - Long.parseLong(st.nextToken())));
		}

		out.close();
		in.close();

	}

}
