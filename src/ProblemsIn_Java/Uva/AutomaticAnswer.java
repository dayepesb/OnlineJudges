package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AutomaticAnswer {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		long casos = Long.parseLong(in.readLine());
		for (int i = 0; i < casos; i++) {
			long decenas;
			long n = Long.parseLong(in.readLine());
			long num = (((((n * 567) / 9) + 7492) * 235) / 47) - 498;
			decenas = (num / 10) % 10;
			if (decenas < 0) {
				decenas = decenas * -1;
			}
			out.write(decenas + "\n");
		}
		out.close();
	}

}
