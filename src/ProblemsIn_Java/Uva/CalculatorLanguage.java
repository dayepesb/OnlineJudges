package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class CalculatorLanguage {
    static HashMap<String,Long> variables = new HashMap<>();
    public static void main(String args []) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        ArrayList<String> list = new ArrayList<>();
        for (String line; !(line = in.readLine().trim()).equalsIgnoreCase("#");)
            list.add(line.replaceAll(" ",""));



        out.close();
        in.close();
    }
}