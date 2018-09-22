package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;

public class KingdomDivision {

    public static void main(String[] args) throws Exception {
        Locale.setDefault(new Locale("us"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        double a, b, c, d;
        StringTokenizer st;
        int cas = 1;
        for (String line; !(line = in.readLine().trim()).equalsIgnoreCase("-1 0 0");) {
            out.printf("Set %d:%n", cas);
            st = new StringTokenizer(line);
            a = Double.parseDouble(st.nextToken());
            b = Double.parseDouble(st.nextToken());
            c = Double.parseDouble(st.nextToken());
            double b1 = (a * c) / b;
            if (b == 0.0 || b == b1)
                out.printf("Poor King!%n");
            else {
                d = ((a + b1) * c + (a + b1) * b1)/(b - b1)+ b1;
                out.printf(d > 0 ? "%.4f%n" : "Poor King!%n", d);
            }
            cas++;
        }

        out.close();
        in.close();
    }
}
