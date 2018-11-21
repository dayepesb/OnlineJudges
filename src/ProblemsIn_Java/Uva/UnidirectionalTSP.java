package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class UnidirectionalTSP {
    static int n, m, g[][], solve[][], path[][];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st;
        try {
            while (true) {
                String line = in.readLine();
                if (line == null) break;
                while (line.trim().equalsIgnoreCase("")) line = in.readLine();
                st = new StringTokenizer(line);
                n = Integer.parseInt(st.nextToken());
                m = Integer.parseInt(st.nextToken());
                g = new int[n][m];
                st = null;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (st == null || !st.hasMoreTokens())
                            st = new StringTokenizer(in.readLine());
                        g[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
                solve = new int[n][m];
                path = new int[n][m];
                for (int i = 0; i < n; Arrays.fill(solve[i], Integer.MAX_VALUE / 2), Arrays.fill(path[i], -1), i++) ;
                dijkstra_PriorityQueue();
                int min = Integer.MAX_VALUE / 2;
                for (int i = 0; i < n; i++) min = Math.min(min, solve[i][m - 1]);
                ArrayList<int[]> paths = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (min == solve[i][m - 1]) {
                        int solvePath[] = new int[m];
                        int indexArray = m - 1;
                        int indexRow = i;
                        solvePath[indexArray--] = indexRow + 1;
                        int colum = m - 1;
                        while (path[indexRow][colum] != -1) {
                            indexRow = path[indexRow][colum--];
                            solvePath[indexArray--] = indexRow + 1;
                        }
                        paths.add(solvePath);
                    }
                }
                Collections.sort(paths, (x, y) -> {
                    for (int i = 0; i < m; i++) {
                        if (x[i] != y[i]) return Integer.compare(x[i], y[i]);
                    }
                    return Integer.compare(x[m - 1], y[m - 1]);
                });
                int[] solution = paths.get(0);
                for (int i = 0; i < m; i++) {
                    if (i == m - 1)
                        out.println(solution[i]);
                    else
                        out.printf("%d ", solution[i]);
                }
                out.println(min);
            }
        } catch (Exception e) {

        }
        out.close();
        in.close();
    }

    static void dijkstra_PriorityQueue() {
        PriorityQueue<node> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q.add(new node(i, 0, g[i][0]));
            solve[i][0] = g[i][0];
        }
        while (!q.isEmpty()) {
            node u = q.poll();
            if (u.y != m - 1) {
                node[] ady = getListAdy(u);
                for (node v : ady) {
                    if (g[v.x][v.y] + solve[u.x][u.y] < solve[v.x][v.y]) {
                        solve[v.x][v.y] = g[v.x][v.y] + solve[u.x][u.y];
                        path[v.x][v.y] = u.x;
                        v.peso = solve[v.x][v.y];
                        q.add(v);
                    }
//                    if (g[v.x][v.y] + solve[u.x][u.y] == solve[v.x][v.y]) {
//                        if (caminoMenor(path[v.x][v.y], u.x, u.y, v))
//                            path[v.x][v.y] = u.x;
//                    }
                }
            }
        }
    }

    private static boolean caminoMenor(int actual, int posible, int colum, node v) {
        System.out.println(v.x + " " + v.y);
        if (colum == 0) {
            if (posible < actual) return true;
            return false;
        }
        int index = colum, columReset = colum, caminoActual[] = new int[colum + 1],
                caminoPosible[] = new int[colum + 1];
        //pinche actual
        int indexRow = actual;
        caminoActual[index--] = indexRow;
        while (path[indexRow][columReset] != -1) {
            indexRow = path[indexRow][columReset--];
            caminoActual[index--] = indexRow;
        }
        //pinche posible
        index = colum;
        columReset = colum;
        indexRow = posible;
        caminoActual[index--] = indexRow;
        while (path[indexRow][columReset] != -1) {
            indexRow = path[indexRow][columReset--];
            caminoActual[index--] = indexRow;
        }
        //comparar
        for (int i = 0; i < colum; i++) {
            if (caminoPosible[i] < caminoActual[i]) return true;
        }
        return false;
    }

    private static node[] getListAdy(node u) {
        node[] list = new node[3];
        list[0] = new node(u.x == 0 ? n - 1 : u.x - 1, u.y + 1, g[u.x == 0 ? n - 1 : u.x - 1][u.y + 1]);
        list[1] = new node(u.x, u.y + 1, g[u.x][u.y + 1]);
        list[2] = new node((u.x + 1) >= n ? 0 : (u.x + 1), u.y + 1, g[(u.x + 1) >= n ? 0 : (u.x + 1)][u.y + 1]);
        return list;
    }

    static class node implements Comparable<node> {
        int x, y, peso;

        public node(int x, int y, int peso) {
            this.x = x;
            this.y = y;
            this.peso = peso;
        }

        @Override
        public int compareTo(node o) {
            return Integer.compare(this.peso, o.peso);
        }
    }
}