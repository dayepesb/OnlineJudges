package ProblemsIn_Java.Uva;

import java.util.Scanner;

public class PetersSmokes {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cigarrilos, colillas;
		while (in.hasNext()) {
			cigarrilos = in.nextInt();
			colillas = in.nextInt();
			System.out.println(cigarrilos + (cigarrilos - 1) / (colillas - 1));
		}
		in.close();
	}

}
