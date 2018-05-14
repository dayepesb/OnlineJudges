package ProblemsIn_Java.LiveArchive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PopularVote {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		long casos = Long.parseLong(in.readLine().trim());
		for (long i = 0; i < casos; i++) {
			int n = Integer.parseInt(in.readLine());
			long[] arr = new long[n];
			for (int j = 0; j < n; j++) {
				arr[j] = Long.parseLong(in.readLine().trim());
			}
			long max = arr[0];
			double t = arr[0];
			int ind = 0;
			boolean iguales = false;
			for (int j = 1; j < n; j++) {
				t += arr[j];
				if (max == arr[j])
					iguales = true;
				if (max < arr[j]) {
					iguales = false;
					ind = j;
					max = arr[j];
				}
			}
			if (iguales) {
				out.println("no winner");
			} else {
				t /= 2;
				if (t >= max) {
					out.println("minority winner " + (ind + 1));
				} else
					out.println("majority winner " + (ind + 1));
			}
		}
		out.close();
	}
}
