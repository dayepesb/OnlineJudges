package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class RomanDigititis {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = 0;
		while ((n = Integer.parseInt(in.readLine().trim())) != 0) {
			int[] arr = new int[5];
			String temp = "ivxlc";
			for (int i = 1; i <= n; i++) {
				String s = getRomanDigit(i);
				for (int j = 0; j < s.length(); j++) {
					arr[temp.indexOf(s.charAt(j))]++;
				}
			}
			out.printf("%d: %d i, %d v, %d x, %d l, %d c\n", n, arr[0], arr[1], arr[2], arr[3], arr[4]);
		}
		out.close();
		in.close();
	}

	static String getRomanDigit(int n) {
		if (n == 100)
			return "c";
		String ret = "";
		int a = n / 10;
		int b = n % 10;
		if (a > 0 && a <= 5) {
			if (a == 5)
				ret += "l";
			else if (a == 4)
				ret += "xl";
			else {
				for (int i = 0; i < a; i++)
					ret += "x";
			}
		} else if (a > 0 && a <= 9) {
			if (a == 9)
				ret += "xc";
			else {
				ret = "l";
				for (int i = 0; i < a - 5; i++)
					ret += "x";
			}
		}

		if (b > 0 && b <= 5) {
			if (b == 5)
				ret += "v";
			else if (b == 4)
				ret += "iv";
			else {
				for (int i = 0; i < b; i++)
					ret += "i";
			}
		} else if (b > 0 && b <= 9) {
			if (b == 9)
				ret += "ix";
			else {
				ret += "v";
				for (int i = 0; i < b - 5; i++)
					ret += "i";
			}
		}
		return ret;
	}
}