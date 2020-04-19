package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CellularStructure {

    public static void main (String [] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine());
        for (int  i = 0 ; i < t ; i++){
            String s = in.readLine();
            int len = s.length();
            if(len%2==0)
                out.println("NUTANT");
            else if(len == 1) {
                out.println(s.charAt(0) == 'A' ? "SIMPLE" : "MUTANT");
            } else {
                if(s.charAt(0) == 'B' && s.charAt(len-1) == 'A')
                    out.println("MUTAGENIC");
                else if(s.charAt(len-1) == 'B' && s.charAt(len-2) == 'A')
                    out.println("FULLY-GROWN");
                else
                    out.println("MUTANT");
            }
        }

        out.close();
        in.close();
    }
}
