package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class CalculatorLanguage {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String args[]) throws Exception {



        out.close();
        in.close();
    }
    static int priorityOp(char c){
        switch (c){
            case '(':return -1;
            case '=':return 3;
            case '+': case '-':return 1;
            case '*': case '/':return 2;
        }
        return -1;
    }

}