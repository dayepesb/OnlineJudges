package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;

public class TheSuperPowers {
    public static void main (String [] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int a [] = new int[105], v [] = new int[105], g = 0;

        for (int i = 2; i <= 64; i++) {
            if (v[i]==0) {
                a[g++] = i;
                continue;
            }

            for (int j = i * 2; j <= 64; j += i) v[j] = 1;

        }

        ArrayList<Long> ans = new ArrayList<>();
        ans.add(1L);
        long MaxT = 1<<16;
        for (long i = 2; i < MaxT; i++) {
            int ti = (int) (Math.ceil(64 * Math.log(2) / Math.log(i)) - 1);
            long now = i * i * i * i;
            ans.add(now);
            for (int j = 1; a[j] <= ti; j++) {
                now *= (a[j] - a[j - 1] == 1 ? i : i * i);
                ans.add(now);
            }

        }
        for(int i = 0 ; i < ans.size() ; i++)out.println(ans.get(i));
        out.close();
        in.close();
    }
}
