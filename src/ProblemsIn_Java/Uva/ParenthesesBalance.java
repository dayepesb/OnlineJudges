package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Stack;

public class ParenthesesBalance {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			String line = in.readLine();
			out.println(solve(line) ? "Yes" : "No");
		}
		out.close();
		in.close();
	}

	public static boolean solve(String line) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);

			if (isOpening(c)) {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				} else {
					char cInStack = stack.pop();
					if (map(cInStack) != c) {
						return false;
					}
				}
			}
		}

		return stack.isEmpty();
	}

	public static boolean isOpening(char c) {
		switch (c) {
		case '(':
		case '[':
			return true;
		default:
			return false;
		}
	}

	public static char map(char c) {
		switch (c) {
		case '(':
			return ')';
		case '[':
			return ']';
		default:
			return ' ';
		}
	}
}