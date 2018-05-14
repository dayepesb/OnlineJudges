package ProblemsIn_Java.CodeForces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WayTooLongWords {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < num; i++) {
			String s = in.readLine().trim();
			if (s.length() > 10) {
				System.out.println(s.charAt(0) + "" + (s.length() - 2) + "" + s.charAt(s.length() - 1));
			} else {
				System.out.println(s);
			}
		}
		in.close();
	}
}
