package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SecretPoems {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);
        int n;
        char dp[][];
        for (String line; (line = in.readLine()) != null; ) {
            n = Integer.parseInt(line.trim());
            dp = new char[n][n];
            for (int i = 0; i < n; dp[i] = in.readLine().trim().toCharArray(), i++) ;
            int indexFilasRecorrido = 0, indexColumnasRecorrido = 1;
            boolean abajo = true;
            StringBuilder sb = new StringBuilder(dp[0][0] + "");
            while (true) {
                if (indexFilasRecorrido >= n || indexColumnasRecorrido >= n)
                    break;
                sb.append(dp[indexFilasRecorrido][indexColumnasRecorrido]);
                if ((indexFilasRecorrido == n - 1 && indexColumnasRecorrido == n - 1)) break;
                if (abajo) {
                    indexFilasRecorrido += 1;
                    indexColumnasRecorrido -= 1;
                } else {
                    indexFilasRecorrido -= 1;
                    indexColumnasRecorrido += 1;
                }

                if (indexFilasRecorrido == 0 && indexColumnasRecorrido == n - 1) {
                    sb.append(dp[indexFilasRecorrido][indexColumnasRecorrido]);
                    indexFilasRecorrido += 1;
                    abajo = true;
                }

                if (indexFilasRecorrido == n - 1) {
                    sb.append(dp[indexFilasRecorrido][indexColumnasRecorrido]);
                    indexColumnasRecorrido += 1;
                    abajo = false;
                } else if (indexColumnasRecorrido == n - 1 && !abajo) {
                    sb.append(dp[indexFilasRecorrido][indexColumnasRecorrido]);
                    indexFilasRecorrido += 1;
                    abajo = true;
                } else if (indexFilasRecorrido == 0) {
                    sb.append(dp[indexFilasRecorrido][indexColumnasRecorrido]);
                    indexColumnasRecorrido += 1;
                    abajo = true;
                } else if (indexColumnasRecorrido == 0) {
                    sb.append(dp[indexFilasRecorrido][indexColumnasRecorrido]);
                    indexFilasRecorrido += 1;
                    abajo = false;
                }
                if (indexColumnasRecorrido == n - 2 && indexFilasRecorrido == n - 1) break;
            }
            int indexCharacter = 0;
            char[][] M = new char[n + 1][n + 1];
            for (int a = 1; a <= n / 2; a++) {
                for (int i = a; i <= n - a; i++) {
                    M[a][i] = sb.charAt(indexCharacter);
                    indexCharacter++;
                }
                for (int i = a; i <= n - a; i++) {
                    M[i][n - a + 1] = sb.charAt(indexCharacter);
                    indexCharacter++;
                }
                for (int i = n - a + 1; i >= a + 1; i--) {
                    M[n - a + 1][i] = sb.charAt(indexCharacter);
                    indexCharacter++;
                }
                for (int i = n - a + 1; i >= a + 1; i--) {
                    M[i][a] = sb.charAt(indexCharacter);
                    indexCharacter++;
                }
            }
            if (n % 2 == 1) {
                M[n / 2 + 1][n / 2 + 1] = sb.charAt(indexCharacter);
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++)
                    out.print(M[i][j]);
                out.println();
            }
        }
        out.close();
        in.close();
    }
}
