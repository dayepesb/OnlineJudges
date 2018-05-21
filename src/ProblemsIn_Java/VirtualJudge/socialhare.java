package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class socialhare {

    static int[] D1;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        char m[][];
        for (String line; (line = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(line);
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            m = new char[r][];
            for (int i = 0; i < r; i++) m[i] = (in.readLine().trim()).toCharArray();

            long cnt = 0;
            while (q-- > 0) {

                String pattern = in.readLine().trim();
                //izq a derecha-derecha a izq
                for (int i = 0; i < r; i++) {
                    StringBuilder wordMat = new StringBuilder(new String(m[i]));
                    cnt += boyerMooreHorspool(wordMat.toString(), pattern, 256);
                    cnt += boyerMooreHorspool(wordMat.reverse().toString(), pattern, 256);
                }
                //arriba abajo- abajo arriba
                for (int j = 0; j < c; j++) {
                    StringBuilder wordMat = new StringBuilder();
                    for (int i = 0; i < r; i++)
                        wordMat.append(m[i][j]);
                    cnt += boyerMooreHorspool(wordMat.toString(), pattern, 256);
                    cnt += boyerMooreHorspool(wordMat.reverse().toString(), pattern, 256);
                }
                System.out.println(cnt);
            }
        }

        out.close();
        in.close();
    }

    static long boyerMooreHorspool(String text, String pattern, int size) {

        ArrayList<Integer> resp = new ArrayList<>();
        char P[] = pattern.trim().toCharArray();
        char T[] = text.trim().toCharArray();
        int offSet = 0;
        int scan = 0;
        int last = P.length - 1;
        int maxOffSet = T.length - P.length;
        preBoyerMooreSuffixBad(P, size);
        long cnt = 0;
        while (offSet <= maxOffSet) {
            for (scan = last; P[scan] == T[scan + offSet]; scan--) {
                if (scan == 0)
                    cnt++;
                if (scan == 0) break;
            }
            offSet += D1[T[offSet + last]];
        }

        return cnt;

    }

    static void preBoyerMooreSuffixBad(char P[], int size) {
        int m = P.length;
        int last = m - 1;
        D1 = new int[size];
        Arrays.fill(D1, m);
        for (int i = 0; i < last; i++) {
            D1[P[i]] = last - i;
        }
    }
}
