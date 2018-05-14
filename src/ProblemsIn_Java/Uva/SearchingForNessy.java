package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SearchingForNessy {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int casos = Integer.parseInt(in.readLine());
		for (int i = 0; i < casos; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			out.println((Integer.parseInt(st.nextToken())/3)*(Integer.parseInt(st.nextToken())/3));
		}
		out.close();
		in.close();

	}
}
