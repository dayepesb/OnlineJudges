package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ClasificacionSimple {
	public static void main(String[] args) throws Exception {
		BufferedReader inAux = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(inAux);
		PrintWriter out = new PrintWriter(System.out);

		int a = in.nextInt(),b=in.nextInt(),c=in.nextInt();
		ArrayList<Integer> ady = new ArrayList<>();
		ady.add(a);
		ady.add(b);
		ady.add(c);
		Collections.sort(ady);

		out.printf("%d%n%d%n%d%n%n%d%n%d%n%d%n",ady.get(0),ady.get(1),ady.get(2),a,b,c);

		out.close();
		in.close();
	}
}
