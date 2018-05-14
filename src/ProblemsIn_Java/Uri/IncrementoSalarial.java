package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class IncrementoSalarial {
	public static void main(String[] args) throws Exception {
		Locale.setDefault(new Locale("eng","US"));
		BufferedReader inAux = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Scanner in = new Scanner(inAux);

		float N, new_salary = 0, earn_Money = 0;

		int parcent = 0;
		N = in.nextFloat();

		if (N >= 0 && N <= 400.00) {
			parcent = 15;
			new_salary = (float) (N + (N * (parcent / 100.00)));
			earn_Money = (float) ((N * (parcent / 100.00)));

		} else if (N >= 400.01 && N <= 800.00) {
			parcent = 12;
			new_salary = (float) (N + (N * (parcent / 100.00)));
			earn_Money = (float) ((N * (parcent / 100.00)));
		} else if (N >= 800.01 && N <= 1200.00) {
			parcent = 10;
			new_salary = (float) (N + (N * (parcent / 100.00)));
			earn_Money = (float) ((N * (parcent / 100.00)));

		} else if (N >= 1200.01 && N <= 2000.00) {
			parcent = 7;
			new_salary = (float) (N + (N * (parcent / 100.00)));
			earn_Money = (float) ((N * (parcent / 100.00)));
		} else if (N >= 2000.01) {
			parcent = 4;
			new_salary = (float) (N + (N * (parcent / 100.00)));
			earn_Money = (float) ((N * (parcent / 100.00)));
		}

		out.printf("Novo salario: %.2f\n", new_salary);
		out.printf("Reajuste ganho: %.2f\n", earn_Money);
		out.print("Em percentual: " + parcent + " %\n");

		out.close();
		in.close();
	}
}
