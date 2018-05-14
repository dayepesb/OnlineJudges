package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FindTheTelephone {
	public static void main(String[] args) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuffer sb = new StringBuffer("");
		String m = "";
		StringBuilder temp = new StringBuilder("");
		while (true) {
			int car = br.read();
			if (car < 0)
				break;
			char c = (char) car;
			sb.append(strM(c));
		}
		System.out.print(sb);
	}

	static char strM(char x) {
		if (x == 'A' || x == 'B' || x == 'C')
			return '2';
		if (x == 'D' || x == 'E' || x == 'F')
			return '3';
		if (x == 'G' || x == 'H' || x == 'I')
			return '4';
		if (x == 'J' || x == 'K' || x == 'L')
			return '5';
		if (x == 'M' || x == 'N' || x == 'O')
			return '6';
		if (x == 'P' || x == 'Q' || x == 'R' || x == 'S')
			return '7';
		if (x == 'T' || x == 'U' || x == 'V')
			return '8';
		if (x == 'W' || x == 'X' || x == 'Y' || x == 'Z')
			return '9';
		return x;
	}

}
