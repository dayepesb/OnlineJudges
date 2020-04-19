package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CleverNamingPatterns {

    static String words [][];
    static int g [][], gt [];
    static boolean visited [];
    static int my [], mx [];
    public static void main(String args []) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int cases = Integer.parseInt(in.readLine().trim());
        for (int c = 1 ; c<=cases;c++){
            int n = Integer.parseInt(in.readLine().trim());

            words = new String[n+1][31];
            g = new int[100][100];
            gt = new int[100];
            visited = new boolean[100];
            my = new int[100];
            mx = new int[100];
            int K [] = new int[30];

            for (int i = 1 ; i <= n ; i++ ){
                StringTokenizer st = new StringTokenizer(in.readLine());
                int nWords = Integer.parseInt(st.nextToken());
                K[i]=nWords;
                for(int j = 0; j < nWords; j++) {
                    words[i][j]= st.nextToken();
                    int x = i;
                    int y = 30+(words[i][j].charAt(0) >= 'a' ? words[i][j].charAt(0)-'a' : words[i][j].charAt(0)-'A');
                    g[y][gt[y]++] = x;
                }
            }

            for(int i = 30; i < 30+n; i++) {
                if(mx[i]==0) {
                    visited = new boolean[100];
                    dfs(i);
                }
            }
            out.printf("Case #%d:", c);
            out.println();
            for(int i = 30; i < 30+n; i++) {
                for(int j = 0; j < K[mx[i]]; j++) {
                    if((words[mx[i]][j].toLowerCase().charAt(0)) == i-30+'a') {
                        out.printf("%c", (words[mx[i]][j].toUpperCase().charAt(0)));
                        for(int k = 1; k<words[mx[i]][j].length(); k++)
                            out.printf("%c", (words[mx[i]][j].toLowerCase().charAt(k)));
                        out.println();
                        break;
                    }
                }
            }

        }

        out.close();
        in.close();
    }

    static boolean dfs(int x) {
        for(int i = 0; i < gt[x]; i++) {
            int y = g[x][i];
            if(!visited[y]) {
                visited[y] = true;
                if(my[y] == 0 || dfs(my[y])) {
                    mx[x] = y;
                    my[y] = x;
                    return true;
                }
            }
        }
        return false;
    }
}
