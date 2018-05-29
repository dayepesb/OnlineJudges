package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class MakeCoins {
    static int coins[];
    static long C[];
    static int W;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(br);
        PrintWriter out = new PrintWriter(System.out);

        coins = new int[22];
        C = new long[10000];
        makeCoins();
        while (in.hasNext()) {
            W = in.nextInt();
            System.out.printf("%d%n",countWays());
        }

        out.close();
        in.close();
    }

    static void makeCoins() {
        for (int i = 1; i <= 21; i++) coins[i] = i * i * i;
    }

    static long countWays() {
        for (int i = 1; i <= W; i++) C[i] = 0;
        C[0] = 1;
        for (int i = 1; i <= 21; i++)
            for (int j = coins[i]; j <= W; j++) {
                C[j] = C[j] + C[j - coins[i]];
            }

        return C[W];
    }
}
