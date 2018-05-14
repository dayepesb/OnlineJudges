package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class AboveAverage {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);

		int testCases = in.nextInt();

		for (int tc = 1; tc <= testCases; tc++) {

			int N = in.nextInt();
			int[] grades = new int[N + 1];
			long sum = 0;
			float avg = 0, percent = 0;

			for (int i = 1; i <= N; i++) {
				grades[i] = in.nextInt();
				sum += grades[i];
			}

			Arrays.sort(grades);
			avg = sum / N;
			for (int i = 1; i <= N; i++) {
				if (Float.compare(grades[i], avg) > 0) {
					percent = ((float) ((N - i) + 1) / N) * 100;
					break;
				}
			}

			out.printf("%.3f", percent);
			out.println("%");
		}

		out.close();
		in.close();

	}

}