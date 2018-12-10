package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class GalaxyCollision {

    static int visited[];
    static int n;
    static ArrayList<Integer>[] graph;

    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        HashMap<String, Integer> points;
        for (String line; (line = in.readLine()) != null; ) {
            n = Integer.parseInt(line.trim());
            points = new HashMap<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points.put(x + "," + y, i);
            }
            graph = new ArrayList[n];
            for (int i = 0; i < n; graph[i] = new ArrayList<>(), i++) ;
            for (Map.Entry<String, Integer> point : points.entrySet()) {
                StringTokenizer st = new StringTokenizer(point.getKey(), ",");
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int lowX = Math.max(x1 - 5, 1), highX = Math.min(x1 + 5, 500002);
                int lowY = Math.max(y1 - 5, 1), highY = Math.min(y1 + 5, 500002);
                for (int x2 = lowX; x2 <= highX; x2++) {
                    for (int y2 = lowY; y2 <= highY; y2++) {
                        if (dist(x1, y1, x2, y2) <= 25 && points.get(x2 + "," + y2) != null && points.get(x2 + "," + y2) != (n - 1)) {
                            if (point.getValue() != points.get(x2 + "," + y2)) {
                                graph[point.getValue()].add(points.get(x2 + "," + y2));
                            }
                        }
                    }
                }
            }

            visited = new int[n];
            Arrays.fill(visited, 0);
            for (int i = 0; i < n; i++) {
                if (graph[i].size() > 0 && visited[i] == 0) {
                    dfs(i, 1);
                }
            }
            int red = 0, blue = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i] == 1) red++;
                else if (visited[i] == -1) blue++;
            }
            out.println(Math.min(red, blue));
        }
        out.close();
        in.close();
    }

    static int dist(int x1, int y1, int x2, int y2) {
        return (int) Math.pow(x1 - x2, 2) + (int) Math.pow(y1 - y2, 2);
    }

    static void dfs(int u, int color) {
        visited[u] = color;
        for (int v : graph[u]) {
            if (visited[v] == 0) {
                dfs(v, color * (-1));
            }
        }
    }
}
