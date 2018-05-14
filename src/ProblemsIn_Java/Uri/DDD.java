package ProblemsIn_Java.Uri;

import java.io.PrintWriter;
import java.util.Scanner;

public class DDD {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n;
		switch (n = in.nextInt()) {
		case 61:
			out.printf("Brasilia\n");
			break;
		case 71:
			out.printf("Salvador\n");
			break;
		case 11:
			out.printf("Sao Paulo\n");
			break;
		case 21:
			out.printf("Rio de Janeiro\n");
			break;
		case 32:
			out.printf("Juiz de Fora\n");
			break;
		case 19:
			out.printf("Campinas\n");
			break;
		case 27:
			out.printf("Vitoria\n");
			break;
		case 31:
			out.printf("Belo Horizonte\n");
			break;
		default:
			out.printf("DDD nao cadastrado\n");
			break;
		}
		out.close();
		in.close();
	}
}
