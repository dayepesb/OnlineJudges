package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class InfectedLand {

    static int[] dx = new int[]{0, 0, -1, -1, -1, 1, 1, 1};
    static int[] dy = new int[]{-1, 1, 0, -1, 1, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = 0;
        while (true) {
            if ((n = Integer.parseInt(in.readLine().trim())) == 0) break;
            ;
            int x = -1, y = -1, s = 0;
            for (int i = 0, k = 0; i < n; ++i) {
                char[] t = in.readLine().toCharArray();
                for (int j = 0; j < n; ++j, ++k)
                    if (t[j] == '@') {
                        x = i;
                        y = j;
                        s |= 1 << k;
                    } else if (t[j] == '#')
                        s |= 1 << k;
            }
            out.println(bfs(n, new Node(x, y, s)));
        }

        out.close();
        in.close();
    }

    static int bfs(int N, Node s) {
        TreeMap<Node, Integer> dist = new TreeMap<Node, Integer>();
        Queue<Node> q = new LinkedList<>();
        dist.put(s, 0);
        q.add(s);
        while (!q.isEmpty()) {
            Node cur = q.remove();

            int d = dist.get(cur);
            if (Integer.bitCount(cur.inf) == 1)
                return d;
            int xx = cur.pos / 5, yy = cur.pos % 5;
            int nxtInf = cur.inf & ~(1 << xx * N + yy);
            for (int k = 0; k < 8; ++k) {
                int x = xx + dx[k], y = yy + dy[k];
                if (!valid(N, x, y))
                    continue;
                int cell = x * N + y;
                if ((cur.inf & 1 << cell) != 0)
                    continue;

                int begin = nxtInf | 1 << cell, end = 1 << cell;
                for (int i = 0; i < N * N; ++i)
                    if (i != cell) {
                        int count = countInfAdj(i / N, i % N, begin, N);
                        if ((begin & 1 << i) == 0) {
                            if (count == 3)
                                end |= 1 << i;
                        } else {
                            if (count == 2 || count == 3)
                                end |= 1 << i;
                        }
                    }
                Node nxt = new Node(x, y, end);
                if (!dist.containsKey(nxt)) {
                    dist.put(nxt, d + 1);
                    q.add(nxt);
                }
            }
        }
        return -1;
    }

    static int countInfAdj(int x, int y, int msk, int N) {
        int c = 0;
        for (int k = 0; k < 8; ++k) {
            int i = x + dx[k], j = y + dy[k];
            if (valid(N, i, j)) {
                int cell = i * N + j;
                if ((msk & 1 << cell) != 0)
                    ++c;
            }
        }
        return c;
    }

    static boolean valid(int N, int i, int j) {
        return i != -1 && j != -1 && i != N && j != N;
    }

    static class Node implements Comparable<Node> {
        int pos, inf;

        Node(int a, int b, int c) {
            pos = a * 5 + b;
            inf = c;
        }

        public int compareTo(Node s) {
            if (inf != s.inf)
                return inf - s.inf;
            return pos - s.pos;
        }
    }
}