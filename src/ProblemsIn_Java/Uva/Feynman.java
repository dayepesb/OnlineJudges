package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Feynman {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		long[] arr = new long[101];
		arr[0] = arr[1] = 1;
		for (int i = 2; i < arr.length; i++) {
			arr[i] = (i * i) + arr[i - 1];
		}
		for (String line; !(line = in.readLine().trim()).equals("0");) {
			int n = Integer.parseInt(line);
			out.println(arr[n]);
		}
		out.close();
	}
}
