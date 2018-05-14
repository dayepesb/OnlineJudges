package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;

public class BilletesYMonedas {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		Locale.setDefault(new Locale("US", "en"));

		double N = Double.parseDouble(in.readLine().trim());
		int inteiro, aux, aux1;

		inteiro = (int) N;
		N = 100 * N;
		aux1 = (int) N;

		out.print("NOTAS:\n");
		out.print(inteiro / 100 + " nota(s) de R$ 100.00\n");
		aux = (inteiro % 100);
		out.print(aux / 50 + " nota(s) de R$ 50.00\n");
		aux = (aux % 50);
		out.print(aux / 20 + " nota(s) de R$ 20.00\n");
		aux = (aux % 20);
		out.print(aux / 10 + " nota(s) de R$ 10.00\n");
		aux = (aux % 10);
		out.print(aux / 5 + " nota(s) de R$ 5.00\n");
		aux = (aux % 5);
		out.print(aux / 2 + " nota(s) de R$ 2.00\n");
		aux = (aux % 2);
		out.print("MOEDAS:\n");
		out.print(aux / 1 + " moeda(s) de R$ 1.00\n");

		aux1 = aux1 % 100;
		out.print(aux1 / 50 + " moeda(s) de R$ 0.50\n");
		aux1 = aux1 % 50;
		out.print(aux1 / 25 + " moeda(s) de R$ 0.25\n");
		aux1 = aux1 % 25;
		out.print(aux1 / 10 + " moeda(s) de R$ 0.10\n");
		aux1 = aux1 % 10;
		out.print(aux1 / 5 + " moeda(s) de R$ 0.05\n");
		aux1 = aux1 % 5;
		out.print(aux1 / 1 + " moeda(s) de R$ 0.01\n");

		out.close();
	}
}
