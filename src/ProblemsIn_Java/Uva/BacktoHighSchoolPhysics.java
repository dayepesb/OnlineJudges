package ProblemsIn_Java.Uva;

import java.util.Scanner;

public class BacktoHighSchoolPhysics {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int v = in.nextInt();
			int m = in.nextInt();
			System.out.println(v*2*m);
		}
		in.close();
	}

}
