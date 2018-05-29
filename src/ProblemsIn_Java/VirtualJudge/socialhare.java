package ProblemsIn_Java.VirtualJudge;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class socialhare {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int r, c, w;
        String line;
        String[] puzzle;
        char[][] m;
        try {
            while ((line = in.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);
                r = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());
                puzzle = new String[r];
                for (int i = 0; i < r; ++i) {
                    puzzle[i] = in.readLine();
                }
                m = new char[r + 2][c + 2];
                for (char[] row : m)
                    Arrays.fill(row, '*');
                for (int i = 0; i < r; ++i)
                    for (int j = 0; j < c; ++j) {
                        char p = puzzle[i].charAt(j);
                        m[i + 1][j + 1] = p;
                    }
                r = m.length;
                c = m[0].length;
                StringBuffer buff = new StringBuffer((r + 2) * (c + 2) * 6);
                for (int i = 0; i < r; ++i) {
                    buff.append(m[i]);
                }
                for (int i = 0; i < c; ++i)
                    for (int j = 0; j < r; j++)
                        buff.append(m[j][i]);
                for (int i = 0; i < r; ++i) concatenatInBuffer(m, buff, i, 0, -1, 1);
                for (int i = 0; i < c; ++i) concatenatInBuffer(m, buff, r - 1, i, -1, 1);
                for (int i = 0; i < c; ++i) concatenatInBuffer(m, buff, r - 1, i, -1, -1);
                for (int i = r - 1; i >= 0; --i) concatenatInBuffer(m, buff, i, c - 1, -1, -1);
                char[] char_m = buff.toString().toCharArray();
                int ans = 0;
                for (int x = 0; x < w; ++x) {
                    char[] word = in.readLine().toCharArray();
                    if (word.length > char_m.length)
                        continue;
                    int[] pattern = strToVec(word, 0, word.length);
                    int[] curr_pattern = strToVec(char_m, 0, word.length);
                    for (int i = 1; i + word.length <= char_m.length; ++i) {
                        --curr_pattern[char_m[i - 1] != '*' ? (char_m[i - 1] - 'a') : 26];
                        ++curr_pattern[char_m[i + word.length - 1] != '*' ? (char_m[i + word.length - 1] - 'a') : 26];
                        if (vecEquals(pattern, curr_pattern)) {
                            ++ans;
                            break;
                        }
                    }
                }
                out.println(ans + "");
            }
        }catch (Exception e){

        }
        out.close();
        in.close();
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
