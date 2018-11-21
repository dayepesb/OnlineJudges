package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PlayOnWords {
    static ArrayList<Integer>[] adjList;
    static int[][] words;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int tc = Integer.parseInt(in.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            int[] deg = new int[26];
            adjList = new ArrayList[26];
            for (int i = 0; i < 26; ++i)
                adjList[i] = new ArrayList<Integer>();
            words = new int[n][2];
            for (int i = 0; i < n; ++i) {
                String x = in.readLine().trim();
                words[i][0] = x.charAt(0) - 'a';
                words[i][1] = x.charAt(x.length() - 1) - 'a';
                deg[words[i][0]]++;
                deg[words[i][1]]--;
                adjList[words[i][0]].add(i + 26);
            }
            int root = -1;
            for (int i = 0; root != -2 && i < 26; ++i)
                if (deg[i] != 0)
                    if (deg[i] == 1)
                        if (root == -1)
                            root = i;
                        else
                            root = -2;
                    else if (deg[i] != -1)
                        root = -2;

            if (connected(root))
                out.println("Ordering is possible.");
            else
                out.println("The door cannot be opened.");
        }
        out.flush();
        out.close();
    }

    static void dfs(int u) {
        visited[u] = true;
        for (int v : adjList[u]) {
            visited[v] = true;
            if (!visited[words[v - 26][1]])
                dfs(words[v - 26][1]);
        }
    }

    static boolean connected(int u) {
        if (u == -2)
            return false;
        if (u == -1)
            for (int i = 0; i < 26; ++i)
                if (adjList[i].size() > 0) {
                    u = i;
                    break;
                }
        visited = new boolean[words.length + 26];
        dfs(u);
        for (int i = 26; i < visited.length; ++i)
            if (!visited[i])
                return false;
        return true;
    }

}
