package ProblemsIn_Java.Uva;

import java.util.Scanner;

public class FunnyEncryptionMethod {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for (int d = 0; d < tc; d++) {
			int decimal = in.nextInt();
			int bitCount1 = Integer.bitCount(decimal);
			int hexaDecimal = Integer.parseInt(Integer.toString(decimal), 16);
			int bitCount2 = Integer.bitCount(hexaDecimal);
			System.out.println(bitCount1 + " " + bitCount2);
		}
	}
}
