package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PackingPolygons {
    static double EPS = 1e-8;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n;
        ArrayList<point> v;
        double r;
        for (String line; !(line = in.readLine().trim()).equalsIgnoreCase("0"); ) {
            n = Integer.parseInt(line);
            v = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                v.add(new point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));
            }
            r = Double.parseDouble(in.readLine().trim());
            r *= r;
            boolean ok = true;
            for (int i = 0; i < n && ok; i++) {
                for (int j = i + 1; j < n && ok; j++) {
                    ok = (distanceSquare(v.get(i), v.get(j)) - 4 * r < EPS);
                }
            }
            if (ok) {
                ok = false;
                for (int i = 0; i < n && !ok; i++) {
                    for (int j = 0; j < n && !ok; j++) {
                        if (i == j) continue;
                        point c = center(v.get(i), v.get(j), r);
                        ok = true;
                        for (int k = 0; k < n; k++) {
                            if (distanceSquare(v.get(k), c) - r > EPS) {
                                ok = false;
                                break;
                            }
                        }
                    }
                }
            }

            if (ok || n == 1) {
                out.println("The polygon can be packed in the circle.");
            } else {
                out.println("There is no way of packing that polygon.");
            }

        }

        out.close();
        in.close();
    }

    private static double distanceSquare(point a, point b) {
        return Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2);
    }

    static point center(point a, point b, double rr) {
        double ab = distanceSquare(a, b);
        double k = Math.sqrt(rr / ab - 0.25);
        point o = new point(((a.x + b.x) / 2 + k * (b.y - a.y)), ((a.y + b.y) / 2 + k * (a.x - b.x)));
        return o;
    }


    static class point {
        double x, y;

        public point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
