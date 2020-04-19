package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TheTreeRoot {

    static int [] dpBest [], dpFail, visited;
    static ArrayList<Integer> lAdy [];

    public static void main(String args []) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(br);
        PrintWriter out = new PrintWriter(System.out);

        while(in.hasNext()){
            String line = in.next();

            int nodes = Integer.parseInt(line.trim());

            if(nodes==0)break;

            lAdy = new ArrayList[nodes+1];

            for (int i = 0 ; i < nodes ;lAdy[i]=new ArrayList<>(), i++);

            dpBest = new int[nodes+1][2];
            dpFail = new int[nodes+1];
            visited = new int[nodes+1];

            for (int i = 0 ; i < nodes ; i++){

                int a = i;
                int m = in.nextInt();
                while(m-->0){
                    int b = in.nextInt()-1;

                    lAdy[a].add(b);
                    lAdy[b].add(a);
                }
            }

            visited[0] = 1;
            dfs(0);
            Arrays.fill(visited,0);
            visited[0] = 1;
            dfs2(0,0);
            int solutionRoots[] = new int[nodes+1], heigthBest = Integer.MAX_VALUE-1, heigthFail = 0;
            for(int i = 0; i < nodes; i++) {
                solutionRoots[i] = Math.max(Math.max(dpBest[i][0], dpBest[i][1]), dpFail[i]);
                heigthBest = Math.min(solutionRoots[i], heigthBest);
                heigthFail = Math.max(solutionRoots[i], heigthFail);
            }
            out.printf("Best Roots  :");
            for(int i = 0; i < nodes; i++) {
                if (solutionRoots[i] == heigthBest)
                    out.printf(" %d", i+1);
            }
            out.println();
            out.printf("Worst Roots :");
            for(int i = 0; i < nodes; i++) {
                if (solutionRoots[i] == heigthFail)
                    out.printf(" %d", i+1);
            }
            out.println();
        }

        out.close();
        in.close();
    }

    static void dfs(int u) {
        for(int v: lAdy[u]){
            if(visited[v] == 0) {
                visited[v] = 1;
                dfs(v);
                if(dpBest[v][0]+1 > dpBest[u][1])
                dpBest[u][1] = dpBest[v][0]+1;
                if(dpBest[u][1] > dpBest[u][0]){
                    int a = dpBest[u][0];

                    dpBest[u][0] = dpBest[u][1];
                    dpBest[u][1] = a;
                }
            }
        }
    }

    static void dfs2(int w, int v) {
        dpFail[w] = v;
        for(int u: lAdy[w]){
            if(visited[u] == 0) {
                visited[u] = 1;
                int hv;
                if (dpBest[u][0] + 1 != dpBest[w][0]){
                    hv = dpBest[w][0];
                }else {
                    hv = dpBest[w][1];
                }
                hv = Math.max(hv, dpFail[w]);
                dfs2(u, hv+1);
            }
        }
    }
}
