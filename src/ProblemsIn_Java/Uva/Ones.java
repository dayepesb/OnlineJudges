package ProblemsIn_Java.Uva;

import java.io.IOException;
import java.util.Scanner;

public class Ones {
	public static void main(String args[]) throws IOException {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int NumberOfOnes = 1;
			int Tmp = 1;
			int Number = in.nextInt();

			while (Tmp != 0) {
				if (Number > Tmp) {
					NumberOfOnes++;
				}
				Tmp = Number > Tmp ? Tmp * 10 + 1 : Tmp % Number;
			}
			System.out.println(NumberOfOnes);
		}

	}
}
