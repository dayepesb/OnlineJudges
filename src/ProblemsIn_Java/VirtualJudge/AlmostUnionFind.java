package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class AlmostUnionFind {
    static Set<Integer>[] sets;
    static int set[];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        for (String line; (line = in.readLine()) != null; ) {
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sets = new HashSet[n+1];
            set = new int[n+1];
            Arrays.fill(set, -1);
            for (int i = 0; i <= n;i++){
                sets[i] = new HashSet<Integer>();
                sets[i].add(i);
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(in.readLine().trim());
                int op = Integer.parseInt(st.nextToken());
                if (op == 1) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    Union(x, y);
                } else if (op == 2) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    Move(x, y);
                } else if (op == 3) {
                    int x = Integer.parseInt(st.nextToken());
                    int count = sets[find(x)].size();
                    int sum = 0;
                    for (int a : sets[find(x)]) sum += a;
                    System.out.println(count + " " + sum);
                }
            }
        }

        out.close();
        in.close();
    }

    private static void Move(int remove, int to) {
    }

    private static void Union(int x, int y) {
    }


    static int find(int x) {
        if (set[x] == -1) {
            return x;
        }
        return find(set[x]);
    }
}
