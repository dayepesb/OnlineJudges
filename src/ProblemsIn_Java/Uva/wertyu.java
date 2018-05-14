package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class wertyu {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		for (String line; (line = in.readLine()) != null;) {
			String res = line.replace("W", "Q").replace("E", "W").replace("R", "E").replace("T", "R").replace("Y", "T")
					.replace("U", "Y").replace("I", "U").replace("O", "I").replace("P", "O").replace("[", "P")
					.replace("]", "[").replace("S", "A").replace("D", "S").replace("F", "D").replace("G", "F")
					.replace("H", "G").replace("J", "H").replace("K", "J").replace("L", "K").replace(";", "L")
					.replace("'", ";").replace("X", "Z").replace("C", "X").replace("V", "C").replace("B", "V")
					.replace("N", "B").replace("M", "N").replace(",", "M").replace(".", ",").replace("/", ".")
					.replace("1", "`").replace("2", "1").replace("3", "2").replace("4", "3").replace("5", "4")
					.replace("6", "5").replace("7", "6").replace("8", "7").replace("9", "8").replace("0", "9")
					.replace("-", "0").replace("=", "-");
			res = res.replace("\\", "]");
//			System.out.println(res);
			out.write(res + "\n");
		}

		in.close();
		out.close();
	}
}
