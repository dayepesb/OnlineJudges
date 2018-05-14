package ProblemsIn_Java.Uri;

import java.io.IOException;
import java.util.Scanner;

public class Intervalo2 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int N, X, in = 0, out = 0;
		int interval_start = 10, interval_end = 20;

		N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			X = sc.nextInt();
			if (X >= interval_start && X <= interval_end) {
				in += 1;
			} else {
				out += 1;
			}
		}
		System.out.print(in + " in\n" + out + " out\n");
	}

}