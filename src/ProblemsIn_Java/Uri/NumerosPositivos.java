package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumerosPositivos {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int pos = 0;
		for (int i = 0; i < 6; i++) {
			double b = Double.parseDouble(in.readLine().trim());
			if (b > 0)
				pos++;
		}
		System.out.println(pos + " valores positivos");
		in.close();
	}
}
