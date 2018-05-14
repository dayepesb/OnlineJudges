package ProblemsIn_Java.Uva;

import java.util.Scanner;

public class KindergartenCountingGame {
	public static void main(String args[]) throws Exception {

		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			boolean start = false;
			int count = 0;
			char[] words = in.nextLine().toCharArray();
			for (char st : words) {
				if (Character.isLetter(st)) {
					if (!start) {
						count++;
						start = true;
					}
				} else {
					start = false;
				}
			}
			System.out.println(count);
		}
	}
}
