package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GleamingtTheCubes {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        while(true){
            int n = Integer.parseInt(in.readLine().trim());
            if(n==0)break;
            StringTokenizer st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()),
                    z = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
            int x1 = x, x2 = x + d;
            int y1 = y, y2 = y + d;
            int z1 = z, z2 = z + d;
            for (int i = 1; i < n; i++) {
                st = new StringTokenizer(in.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                z = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                x1 = Math.max(x1, x);
                x2 = Math.min(x2, x + d);
                x2 = Math.max(x1, x2);
                y1 = Math.max(y1, y);
                y2 = Math.min(y2, y + d);
                y2 = Math.max(y1, y2);
                z1 = Math.max(z1, z);
                z2 = Math.min(z2, z + d);
                z2 = Math.max(z1, z2);
            }
            out.printf("%d\n", (x2 - x1) * (y2 - y1) * (z2 - z1));
        }
        out.close();
        in.close();
    }
}
