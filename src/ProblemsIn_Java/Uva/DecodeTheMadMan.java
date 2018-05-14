package ProblemsIn_Java.Uva;

import java.util.Scanner;

public class DecodeTheMadMan {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str, keyboard;
		int len;
		keyboard = "`1234567890-=qwertyuiop[]\\asdfghjkl;'zxcvbnm,./";
		while (in.hasNextLine()) {
			str = in.nextLine();
			len = str.length();
			str = str.toLowerCase();
			for (int i = 0; i < len; i++) {
				if (str.charAt(i) == ' ')
					System.out.print(" ");
				else {
					System.out.print(keyboard.charAt(keyboard.indexOf(str.charAt(i)) - 2));
				}
			}
			System.out.println();
		}

	}
}
