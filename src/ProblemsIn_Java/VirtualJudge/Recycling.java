package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Recycling {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        char buf[];
        int n = 0;
        int g[][] = new int[105][5];
        String line;
        while ((line = in.readLine()) != null && line.charAt(0) != '#') {
            buf = line.trim().toCharArray();
            if (buf[0] == 'e') {
                int mn = 0xfffff, ans = 0, tmp;
                for (int i = 0; i < n; i++) {
                    tmp = 0;
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < 5; k++) {
                            if (g[i][k] != g[j][k])
                                tmp++;
                        }
                    }
                    if (tmp < mn) {
                        mn = tmp;
                        ans = i + 1;
                    }
                }
                out.printf("%d%n", ans);
                n = 0;
            } else {
                for (int i = 0; i < 5; i++) {
                    g[n][ch2int(buf[i * 4])] = buf[i * 4 + 2];
                }
                n++;
            }
        }

        out.close();
        in.close();
    }

    static int ch2int(char c) {
        if (c == 'r') return 0;
        if (c == 'o') return 1;
        if (c == 'y') return 2;
        if (c == 'g') return 3;
        if (c == 'b') return 4;
        return -1;
    }
}
