package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TiempoDeJuego {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(in.readLine());
		int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
		int dt = b - a;
		if (dt < 0) {
			dt = 24 + (b - a);
		}
		if (a == b) {
			out.println("O JOGO DUROU 24 HORA(S)");
		} else {
			out.printf("O JOGO DUROU %d HORA(S)%n", dt);
		}

		out.close();
		in.close();
	}
}
