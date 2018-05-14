package ProblemsIn_Java.Uri;

import java.util.Scanner;

public class Divisors1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int d = in.nextInt();
		for (int i = 1; i <= d/2; i++) {
			if(d%i==0)System.out.println(i);
		}
		System.out.println(d);

		in.close();
	}

}
