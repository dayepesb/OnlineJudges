package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Anagrams {

	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(in.readLine().trim());
		for (int j = 0; j < cases; j++) {
			String m = in.readLine().trim();
			Letter l[] = new Letter[m.length()];
			for (int i = 0; i < m.length(); i++) {
				l[i] = new Letter();
				l[i].setX(m.charAt(i));
			}
			Arrays.sort(l);
			char[] n = new char[m.length()];
			for (int i = 0; i < m.length(); i++) {
				n[i] = l[i].getX();
			}
			m = new String(n);
			permutationsChar(0, m, new boolean[m.length()], new char[m.length()]);
		}
		out.close();
		in.close();
	}

	public static void permutationsChar(int i, String s, boolean[] v, char[] res) {
		if (i == res.length) {
			out.println(new String(res));
		} else {
			for (int j = 0; j < s.length(); j++) {
				if (!v[j]) {
					if ((j > 0 && !v[j - 1] && s.charAt(j - 1) == s.charAt(j))) {
						continue;
					}
					v[j] = true;
					res[i] = s.charAt(j);
					permutationsChar(i + 1, s, v, res);
					v[j] = false;
					res[i] = '-';
				}
			}
		}
	}
}

class Letter implements Comparable<Letter> {

	char x;
	Boolean UP;

	public Boolean getUP() {
		return UP;
	}

	public void setUP(Boolean UP) {
		this.UP = UP;
	}

	public char getX() {
		return x;
	}

	public void setX(char x) {
		this.x = x;
	}

	@Override
	public int compareTo(Letter m) {
		if (m.getX() == this.getX()) {
			return 0;
		}
		if (m.getX() > 96 && this.getX() > 96) {
			if (m.getX() > this.getX()) {
				return -1;
			} else {
				return 1;
			}
		} else if (m.getX() > 96 && this.getX() > 64) {
			if (m.getX() - 32 > this.getX()) {
				return -1;
			} else if (m.getX() - 32 == this.getX()) {
				return -1;
			} else {
				return 1;
			}
		} else if (m.getX() > 64 && this.getX() > 96) {
			if (m.getX() > this.getX() - 32) {
				return -1;
			} else {
				return 1;
			}
		}
		if (m.x > this.getX()) {
			return -1;
		} else {
			return 1;
		}
	}
}