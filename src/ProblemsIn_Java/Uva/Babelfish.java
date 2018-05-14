package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;

public class Babelfish {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		HashMap<String, String> mapa = new HashMap<String, String>();

		String line;
		while (!(line = in.readLine()).isEmpty()) {
			String[] s = line.split("[ ]+");
			String valor = s[0];
			String llave = s[1];
			mapa.put(llave, valor);
		}

		while ((line = in.readLine()) != null) {
			if (mapa.containsKey(line)) {
				out.println(mapa.get(line));
			} else {
				out.println("eh");
			}
		}

		out.close();
		in.close();
	}

}
