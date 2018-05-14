package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AcarrearONoAcarrear {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		for (String line; (line=in.readLine())!=null;) {
			StringTokenizer st = new StringTokenizer(line);
			long r = Long.parseLong(st.nextToken())^Long.parseLong(st.nextToken());
			out.println(r);
		}

		out.close();
		in.close();
	}

}
