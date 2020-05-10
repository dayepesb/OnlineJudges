package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SubExpressionCounting {
    public static void main(String [] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out  = new PrintWriter(System.out);


        for( String line; (line = in.readLine())!=null ; ){
            String alpha = processString(line);
            String beta = processString(in.readLine());

            int ans = 0;
            int last = 0;
            while (last != -1) {
                if (alpha.length() > 3)
                    last = kmp(beta, alpha, last);
                else
                    last = beta.indexOf(alpha, last);

                if (last != -1) {
                    ans += 1;
                    last += 1;
                }
            }
            out.println(ans);
        }

        out.close();
        in.close();
    }

    static int kmp(String S, String W, int last) {
        int m = last;
        int[] T = borderkmp(W);
        for (int i = 0; m+i < S.length() ; ) {
            if (W.charAt(i) == S.charAt(m+i)) {
                if (i == W.length()-1)
                    return m;
                i += 1;
            } else {
                if (T[i] > -1) {
                    m += i - T[i];
                    i = T[i];
                } else {
                    i = 0;
                    m += 1;
                }
            }
        }
        return -1;
    }

    static int[] borderkmp(String cadena) {
        int[] P = new int[cadena.length()];
        P[0] = -1;
        P[1] = 0;
        int cnd = 0;
        for (int i = 1; i < cadena.length();) {
            if (cadena.charAt(i-1) == cadena.charAt(cnd)) {
                P[i] = cnd + 1;
                cnd += 1;
                i += 1;
            } else if (cnd > 0) {
                cnd = P[cnd];
            } else {
                P[i] = 0;
                i += 1;
            }
        }
        return P;
    }

    static boolean isOperator(char c){
        if(c == '+' || c == '-' || c == '*' || c == '/')
            return true;
        return false;
    }

    static boolean isLetter(char c){
        if(c - 'a' >= 0 && c - 'a' <= 26)
            return true;
        return false;
    }

    static boolean isNumber(char c){
        if(c - '0' >= 0 && c - '0' <= 9)
            return true;
        return false;
    }

    static String processString(String line) {
        StringBuilder ans = new StringBuilder();
        boolean previusNumber = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (previusNumber && !isNumber(c)) {
                previusNumber = false;
                ans.append('x');
            }

            if (isOperator(c)) {
                ans.append('y');
            } else if (isLetter(c)) {
                ans.append('x');
            } else if (isNumber(c)) {
                previusNumber = true;
            } else {
                ans.append(c);
            }
        }

        if (previusNumber){
            ans.append('x');
        }

        return ans.toString();
    }
}
