package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TreeSumming {
    static int n, index, sum;
    static StringBuilder sb = new StringBuilder("");

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st;
        try {
            for (String line; (line = in.readLine().trim()) != null && !line.equalsIgnoreCase(""); )
                sb.append(line.replace(" ", ""));
        } catch (Exception e) {
        }
        int x = 0;
        StringBuilder sb2 = new StringBuilder("");
        for (index = 0; index < sb.length(); ) {
            char c = sb.charAt(index++);
            if (c != '(') sb2.append(c);
            else {
                n = Integer.parseInt(sb2.toString());
                sum = 0;
                System.out.println(recursion(false)[1] ? "yes" : "no");
                index++;
                sb2 = new StringBuilder("");
            }
        }
        out.close();
        in.close();
    }

    //primer parametro es si es hoja el segundo es si esa hoja suma
    static boolean[] recursion(boolean esHijoDerecho) {
        if (esHijoDerecho)
            index++;
        if (sb.charAt(index) == ')') return new boolean[]{true, false};
        StringBuilder sb3 = new StringBuilder("");
        while (true) {
            char c = sb.charAt(index++);
            if (c != '(') sb3.append(c);
            else break;
        }
        int number = Integer.parseInt(sb3.toString());
        sum += number;
        boolean[] hijoIzquierdo = recursion(false);
        index++;
        boolean[] hijoDerecho = recursion(true);
        index++;
        if (hijoIzquierdo[0] && hijoDerecho[0]) {
            boolean res = false;
            if (sum == n) res = true;
            sum -= number;
            return new boolean[]{false, res};
        }
        sum -= number;
        return new boolean[]{false, hijoIzquierdo[1] || hijoDerecho[1]};
    }
}
