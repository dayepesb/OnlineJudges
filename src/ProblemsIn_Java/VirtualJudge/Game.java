import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 07-01-2018
 * @time 0.000 ms
 */
public class Game {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st;
        char tab[][];
        int tx = Integer.parseInt(in.readLine());
        while (tx-- >= 0) {
            tab = new char[5][];
            int rows = 5;
            while (rows-- >= 0) {
                System.out.prinln(4 - rows);
                tab[4 - rows] = in.readLine().toUpperCase().toCharArray();
            }
            System.exit(0);
            boolean lineA = false;
            boolean lineB = false;
            for (int i = 0; i < 5; i++) {
                int a1 = comprobarDiagonal(i, 0, tab);
                if (a1 != 4) {
                    out.println(a1 == 2 ? "win B" : (a1 == 1 ? "win A" : "draw"));
                    break;
                }
                a1 = comprobarDiagonal(0, i, tab);
                if (a1 != 4) {
                    out.println(a1 == 2 ? "win B" : (a1 == 1 ? "win A" : "draw"));
                    break;
                }
                a1 = horizontal(i, tab);
                if (a1 != 4) {
                    out.println(a1 == 2 ? "win B" : (a1 == 1 ? "win A" : "draw"));
                    break;
                }
                a1 = vertical(i, tab);
                if (a1 != 4) {
                    out.println(a1 == 2 ? "win B" : (a1 == 1 ? "win A" : "draw"));
                    break;
                }
            }

        }
        in.close();
        out.close();
    }

    public static int horizontal(int x, char tab[][]) {
        int countA = 0;
        int countB = 0;
        char anterior = 'F';
        boolean winA = false;
        boolean winB = false;
        //hacia la derecha
        int j = 0;
        for (int i = x; j <= 5; j++) {
            if (anterior == tab[i][j])
                if (anterior == 'A') countA++;
                else countB++;
            else {
                anterior = tab[i][j];
                countA = tab[i][j] == 'A' ? 1 : 0;
                countB = tab[i][j] == 'A' ? 0 : 1;
            }
            if (countA >= 3) winA = true;
            if (countB >= 3) winB = true;
        }
        if (winA && winB) return 0;
        else if (winA) return 1;
        else if (winB) return 2;
        return 4;
    }

    public static int vertical(int x, char tab[][]) {
        int countA = 0;
        int countB = 0;
        char anterior = 'F';
        boolean winA = false;
        boolean winB = false;
        //hacia la derecha
        int j = x;
        for (int i = 0; i <= 5; i++) {
            if (anterior == tab[i][j])
                if (anterior == 'A') countA++;
                else countB++;
            else {
                anterior = tab[i][j];
                countA = tab[i][j] == 'A' ? 1 : 0;
                countB = tab[i][j] == 'A' ? 0 : 1;
            }
            if (countA >= 3) winA = true;
            if (countB >= 3) winB = true;
        }
        if (winA && winB) return 0;
        else if (winA) return 1;
        else if (winB) return 2;
        return 4;
    }

    public static int comprobarDiagonal(int x, int y, char tab[][]) {
        int countA = 0;
        int countB = 0;
        char anterior = 'F';
        boolean winA = false;
        boolean winB = false;
        //hacia la derecha
        int j = y;
        for (int i = x; i < 5 && j < 5 && i >= 0 && j >= 0; i++, j++) {
            if (anterior == tab[i][j])
                if (anterior == 'A') countA++;
                else countB++;
            else {
                anterior = tab[i][j];
                countA = tab[i][j] == 'A' ? 1 : 0;
                countB = tab[i][j] == 'A' ? 0 : 1;
            }
            if (countA >= 3) winA = true;
            if (countB >= 3) winB = true;
        }
        //hacia la izquierda
        j = y;
        for (int i = x; i < 5 && j < 5 && i >= 0 && j >= 0; i++, j--) {
            if (anterior == tab[i][j])
                if (anterior == 'A') countA++;
                else countB++;
            else {
                anterior = tab[i][j];
                countA = tab[i][j] == 'A' ? 1 : 0;
                countB = tab[i][j] == 'A' ? 0 : 1;
            }
            if (countA >= 3) winA = true;
            if (countB >= 3) winB = true;
        }

        if (winA && winB) return 0;
        else if (winA) return 1;
        else if (winB) return 2;
        return 4;
    }

}
