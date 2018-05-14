package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class SocialHare {
	public static void main(String[] args) throws Exception {
		int r, c, w;
		String line;
		String[] puzzle, temp;
		char[][] m;
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
			while ((line = in.readLine()) != null) {
				// Read
				temp = line.split(" ");
				r = Integer.parseInt(temp[0]);
				c = Integer.parseInt(temp[1]);
				w = Integer.parseInt(temp[2]);
				puzzle = new String[r];
				for (int i = 0; i < r; ++i) {
					puzzle[i] = in.readLine();
				}

				// Make a matrix surrounded by *
				m = new char[r + 2][c + 2];
				for (char[] row : m) {
					Arrays.fill(row, '*');
				}
				for (int i = 0; i < r; ++i) {
					for (int j = 0; j < c; ++j) {
						char p = puzzle[i].charAt(j);
						m[i + 1][j + 1] = p;
					}
				}
				// Make a single string with the new matrix, we don't care if we
				// add a diagonal
				// more than once, we only care whether a string is in the
				// puzzle or not,
				// not how many times it appears in total.
				r = m.length;
				c = m[0].length;

				// Rows
				StringBuffer buff = new StringBuffer((r + 2) * (c + 2) * 6);
				for (int i = 0; i < r; ++i) {
					buff.append(m[i]);
				}
				// Cols
				for (int i = 0; i < c; ++i) {
					for (int j = 0; j < r; j++) {
						buff.append(m[j][i]);
					}
				}
				// Diagonals, we use four even though not all of them are
				// necessary Diagonals right up
				for (int i = 0; i < r; ++i) {
					concatenatInBuffer(m, buff, i, 0, -1, 1);
				}
				for (int i = 0; i < c; ++i) {
					concatenatInBuffer(m, buff, r - 1, i, -1, 1);
				}
				// Diagonals left up
				for (int i = 0; i < c; ++i) {
					concatenatInBuffer(m, buff, r - 1, i, -1, -1);
				}
				for (int i = r - 1; i >= 0; --i) {
					concatenatInBuffer(m, buff, i, c - 1, -1, -1);
				}
				char[] char_m = buff.toString().toCharArray();
				int ans = 0;
				// Compare the pattern with the current vector of the word.
				// Compare over the 26 letters of the alphabet + * every time.
				for (int x = 0; x < w; ++x) {
					char[] word = in.readLine().toCharArray();
					// No need to search for a big word in a small puzzle.
					if (word.length > char_m.length) {
						continue;
					}
					int[] pattern = strToVec(word, 0, word.length);
					int[] curr_pattern = strToVec(char_m, 0, word.length);
					// The pattern is never at the beginning, because of the
					// asterisks,
					// we can go straight to position 1.
					for (int i = 1; i + word.length <= char_m.length; ++i) {
						--curr_pattern[char_m[i - 1] != '*' ? (char_m[i - 1] - 'a') : 26];
						++curr_pattern[char_m[i + word.length - 1] != '*' ? (char_m[i + word.length - 1] - 'a') : 26];
						if (vecEquals(pattern, curr_pattern)) {
							++ans;
							break;
						}
					}
				}
				out.write(ans + "");
				out.newLine();
			}
		}
	}

	public static int[] strToVec(char[] s, int start, int length) {
		int[] ret = new int[27];
		for (int i = start; i < start + length; ++i) {
			++ret[s[i] != '*' ? (s[i] - 'a') : 26];
		}
		return ret;
	}

	public static boolean vecEquals(int[] a, int[] b) {
		for (int i = 0; i < a.length; ++i) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	public static void concatenatInBuffer(char[][] m, StringBuffer buff, int row, int col, int movr, int movc) {
		while (row >= 0 && col >= 0 && row < m.length && col < m[0].length) {
			buff.append(m[row][col]);
			row += movr;
			col += movc;
		}
	}

}
