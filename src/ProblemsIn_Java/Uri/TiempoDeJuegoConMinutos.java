package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TiempoDeJuegoConMinutos {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(in.readLine());

		int start_h = Integer.parseInt(st.nextToken()), start_m = Integer.parseInt(st.nextToken()),
				end_h = Integer.parseInt(st.nextToken()), end_m = Integer.parseInt(st.nextToken()), duration_h,
				duration_m;

		duration_h = end_h - start_h;

		if (duration_h < 0) {
			duration_h = 24 + (end_h - start_h);
		}

		duration_m = end_m - start_m;
		if (duration_m < 0)

		{
			duration_m = 60 + (end_m - start_m);
			duration_h--;
		}

		if (start_h == end_h && start_m == end_m)

		{
			out.printf("O JOGO DUROU 24 HORA(S) E 0 MINUTO(S)\n");
		} else
			out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n", duration_h, duration_m);

		out.close();
		in.close();
	}
}
