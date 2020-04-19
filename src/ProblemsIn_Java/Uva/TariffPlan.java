package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TariffPlan {
    public static void main (String [] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int cases = Integer.parseInt(in.readLine());
        for (int i = 1 ; i <= cases; i++){
            int calls = Integer.parseInt(in.readLine());
            StringTokenizer st = new StringTokenizer(in.readLine());
            int mile = 0 , juice = 0;

            while(st.hasMoreTokens()){
                int q = Integer.parseInt(st.nextToken());
                mile += mile(q);
                juice += juice(q);
            }

            int best = 0;
            String chose = "";

            if( mile < juice ) {
                best = mile;
                chose = "Mile ";
            }else if (juice < mile){
                best = juice;
                chose = "Juice ";
            } else {
                best = juice;
                chose = "Mile Juice ";
            }
            out.println("Case "+i+": "+chose+best);
        }

        in.close();
        out.close();
    }

    static long mile(long n) {
        long res = 0;
        int k = (int)(n / 30);
        for(int i = 0 ; i <= k ; i++)
            res += 10;
        return res;
    }

    static long juice(long n) {
        long res = 0;
        int k = (int)(n / 60);
        for(int i = 0 ; i <= k ; i++)
            res += 15;
        return res;
    }

}
