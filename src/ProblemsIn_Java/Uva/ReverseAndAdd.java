package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ReverseAndAdd {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int casos = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < casos; i++) {
			int ciclo = 0;
			String num = in.readLine(),reverse;
			do{
				ciclo++;
				reverse = new StringBuilder(num).reverse().toString();
				num = Long.parseLong(num)+Long.parseLong(reverse)+"";
			}while(!num.equals(new StringBuilder(num).reverse().toString()));
			out.println(ciclo+" "+num);
		}

		out.close();
		in.close();
	}
}
