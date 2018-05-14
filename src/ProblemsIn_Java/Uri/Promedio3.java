package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Promedio3 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		float N1, N2, N3, N4, average, N5, recalaverage;
		StringTokenizer st = new StringTokenizer(in.readLine());
		N1 = Float.parseFloat(st.nextToken());

		N2 = Float.parseFloat(st.nextToken());

		N3 = Float.parseFloat(st.nextToken());

		N4 = Float.parseFloat(st.nextToken());

		average = ((N1 * 2) + (N2 * 3) + (N3 * 4) + (N4 * 1)) / 10;

		if (average >= 7.0) {

			System.out.printf("Media: %.1f\n", average);

			System.out.print("Aluno aprovado.\n");

		}

		else if (average >= 5.0 && average <= 6.9) {

			System.out.printf("Media: %.1f\n", average);

			System.out.print("Aluno em exame.\n");

			N5 = Float.parseFloat(in.readLine().trim());

			System.out.printf("Nota do exame: %.1f\n", N5);

			recalaverage = (average + N5) / 2;

			if (recalaverage >= 5.0) {

				System.out.print("Aluno aprovado.\n");

			} else {

				System.out.print("Aluno reprovado.\n");

			}

			System.out.printf("Media final: %.1f\n", recalaverage);

		}

		else if (average < 5.0) {

			System.out.printf("Media: %.1f\n", average);

			System.out.print("Aluno reprovado.\n");

		}
		in.close();
	}

}
