package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;

public class HowFar {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        Locale.setDefault(new Locale("en"));
        int n, T;
        while (true) {
            try {
                StringTokenizer st = new StringTokenizer(in.readLine());
                n = Integer.parseInt(st.nextToken());
                T = Integer.parseInt(st.nextToken());
                double currX = 0;
                double currY = 0;
                for (int i = 0; i < n; i++) {
                    if (i > 0) out.printf(" ");
                    double r, t;
                    st = new StringTokenizer(in.readLine());
                    r = Integer.parseInt(st.nextToken());
                    t = Integer.parseInt(st.nextToken());
                    double angle = 2.0 * Math.PI * (double) T / t;
                    currX += r * Math.cos(angle);
                    currY += r * Math.sin(angle);
                    out.printf("%.4f", Math.sqrt(currX * currX + currY * currY));
                }
                out.printf("\n");
            } catch (Exception e) {
                break;
            }
        }

        out.close();

        in.close();
    }
}
/**
 * 3 5
 * 20 5
 * 30 5
 * 40 5
 **/