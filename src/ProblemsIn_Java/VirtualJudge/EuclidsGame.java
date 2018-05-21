package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EuclidsGame {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String sol[] = {"Stan wins", "Ollie wins"};
        for (String line; (line = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            if(a+b==0)break;
            out.println(sol[dfs(0, Math.max(a, b), Math.min(a, b))]);
        }

        out.close();
        in.close();
    }

    private static int dfs(int p, int a, int b) {
        if (b == 0) return p ^ 1;
        int win = p ^ 1;
        if (dfs(p ^ 1, b, a % b) == p)
            win = p;
        if (a / b != 1 && dfs(p ^ 1, b + (a % b), b) == p)
            win = p;
        return win;
    }
}
