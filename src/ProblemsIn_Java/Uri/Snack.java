package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Snack {
	static HashMap<Double, Double> table;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		llenar();
		for (String line; (line = in.readLine()) != null;) {
			StringTokenizer st = new StringTokenizer(line);
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			out.printf("Total: R$ %.2f%n",table.get(x)*y);
		}
		in.close();
		out.close();
	}
	static void llenar(){
		table = new HashMap<>();
		table.put(1., 4.0);
		table.put(2., 4.50);
		table.put(3., 5.0);
		table.put(4., 2.0);
		table.put(5., 1.50);
	}
}
