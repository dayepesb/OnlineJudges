package ProblemsIn_Java.Uva;

import java.io.PrintWriter;
import java.util.Scanner;

public class ExactSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while (in.hasNext()) {
			int N = in.nextInt();
			int[] count = new int[1000005];
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = in.nextInt();
				count[arr[i]]++;
			}
			int M = in.nextInt();
			int dif = 1000005, x = 0, y = 0;
			for (int i = 0; i < N; i++) {
				try {
					int sisa = M - arr[i];
					if (sisa > 0 && ((sisa == arr[i] && count[arr[i]] > 1) || (sisa != arr[i] && count[sisa] > 0))
							&& Math.abs(sisa - arr[i]) < dif) {
						dif = Math.abs(sisa - arr[i]);
						x = arr[i];
						y = sisa;
					}
				} catch (Exception e) {
				}
			}
			if (x > y) {
				x ^= y;
				y ^= x;
				x ^= y;
			}
			out.println("Peter should buy books whose prices are " + x + " and " + y + ".\n");
		}
		out.close();
	}
}