package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class OOPS {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String opr[] = {"ADD", "SUB", "MUL", "DIV", "MOV", "BREQ", "BRLE", "BRLS", "BRGE", "BRGR", "BRNE", "BR", "AND", "OR", "XOR", "NOT"};
        String opCode[] = {"R", "$", "PC+", ""};
        int opN[] ={2,  2,  2,  2,  2,  1,  1,  1,1,  1,  1,  1,  3,  3,  3,  1};
        for(String line; (line = in.readLine().trim())!=null;){

        }


        out.close();
        in.close();
    }
}
