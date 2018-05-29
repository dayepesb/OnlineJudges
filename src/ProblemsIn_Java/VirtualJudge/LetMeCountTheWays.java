package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class LetMeCountTheWays {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int[] cents = {5, 10, 25, 50};
        long res[] = new long[30002];
        for(int i = 0; i < res.length; ++i)
            res[i] = 1;

        for(int i = 0; i < 4; ++i){
            for(int j = cents[i]; j < res.length; ++j)
                res[j] += res[j - cents[i]];
        }

        for (String line; (line = in.readLine()) != null; ) {
            if((line.equals("")))break;
            int b =Integer.parseInt(line.trim());
            long a = res[b];
            if(a==1)out.printf("There is only %d way to produce %d cents change.%n",a,b);
            else out.printf("There are %d ways to produce %d cents change.%n",a,b);
        }
        out.close();
        in.close();
    }

}
