package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CocircularPoints {
    static double EPS = 1e-6;

    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n;
        point D[] = new point[128];
        while (true) {
            n = Integer.parseInt(in.readLine().trim());
            if (n == 0) break;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                D[i] = new point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
            }
            int sol = Math.min(2, n);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (Math.abs(cross(D[i], D[j], D[k])) < EPS)
                            continue;
                        point o = circle(D[i], D[j], D[k]);
                        double d = dist2(o, D[i]);
                        int cnt = 0;
                        for (int p = 0; p < n; p++) {
                            if (Math.abs(d - dist2(D[p], o)) < EPS)
                                cnt++;
                        }
                        sol = Math.max(sol, cnt);
                    }
                }
            }
            out.printf("%d\n", sol);
        }

        out.close();
        in.close();
    }

    static double dist(point a, point b) {
        return Math.hypot(a.x - b.x, a.y - b.y);
    }

    static double dist2(point a, point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    static double length(point a) {
        return Math.hypot(a.x, a.y);
    }

    static double dot(point a, point b) {
        return a.x * b.x + a.y * b.y;
    }

    static double cross2(point a, point b) {
        return a.x * b.y - a.y * b.x;
    }

    static double cross(point o, point a, point b) {
        return (a.x - o.x) * (b.y - o.y) - (a.y - o.y) * (b.x - o.x);
    }

    static double angle(point a, point b) {
        return Math.acos(dot(a, b) / length(a) / length(b));
    }

    static point rotateRadian(point a, double radian) {
        double x, y;
        x = a.x * Math.cos(radian) - a.y * Math.sin(radian);
        y = a.x * Math.sin(radian) + a.y * Math.cos(radian);
        return new point(x, y);
    }

    static point getIntersection(point p, point t1, point q, point t2) {
        double a1, a2, b1, b2, c1, c2;
        double dx, dy, d;
        a1 = t1.y;
        b1 = -t1.x;
        c1 = a1 * p.x + b1 * p.y;
        a2 = t2.y;
        b2 = -t2.x;
        c2 = a2 * q.x + b2 * q.y;
        d = a1 * b2 - a2 * b1;
        dx = b2 * c1 - b1 * c2;
        dy = a1 * c2 - a2 * c1;
        return new point(dx / d, dy / d);
    }

    static point circle(point a, point b, point c) {
        point mab = a.add(b).div(2);
        point mbc = b.add(c).div(2);
        point lab = b.substract(a), lbc = c.substract(b);

        double t = lab.x;
        lab.x = lab.y;
        lab.y = t;
        t = lbc.x;
        lbc.x = lbc.y;
        lbc.y = t;

        lab.x = -lab.x;
        lbc.x = -lbc.x;
        return getIntersection(mab, lab, mbc, lbc);
    }

    static class point {
        double x, y;

        public point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public boolean smallerThan(point a) {
            if (Math.abs(x - a.x) > EPS)
                return x < a.x;
            return y < a.y;
        }

        public point add(point a) {
            return new point(x + a.x, y + a.y);
        }

        public point substract(point a) {
            return new point(x - a.x, y - a.y);
        }

        public point div(double a) {
            return new point(x / a, y / a);
        }
    }
}
