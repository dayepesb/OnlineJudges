package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;

public class A_Multiplication_Game {

    public static HashMap<Long, Boolean> map;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        String line;
        map = new HashMap<>();

        for (; (line = in.readLine()) != null; ) {

            map.clear();
            long n = Long.parseLong(line.trim());

            if (win(1, n)) {
                out.println("Stan wins.");
            } else {
                out.println("Ollie wins.");
            }
        }

        out.close();
        in.close();
    }

    public static boolean win(long p, long n) {
        if (p >= n) {
            map.put(p, false);
            return false;
        }
        for (int i = 2; i <= 9; ++i) {
            boolean winning = map.containsKey(p * i) ? map.get(p * i) : win(p * i, n);
            if (!winning) {
                map.put(p, true);
                return true;
            }
        }
        map.put(p, false);
        return false;
    }

}
