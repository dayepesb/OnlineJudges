package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Consumption {
	public static void main(String[] args)  throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		out.printf("%.3f km/l%n",Double.parseDouble(in.readLine().trim())/Double.parseDouble(in.readLine().trim()));

		out.close();
		in.close();
	}
}
