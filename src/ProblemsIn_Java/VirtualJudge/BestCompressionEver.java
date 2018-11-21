package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BestCompressionEver {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = in.readLine();
            if (line == null) break;
            StringTokenizer st = new StringTokenizer(line);
            long n = Long.parseLong(st.nextToken()), m = Long.parseLong(st.nextToken());
            if(n<=Math.pow(2,m+1)-1){
                System.out.println("yes");
            }else
                System.out.println("no");
        }
        in.close();
    }
}
