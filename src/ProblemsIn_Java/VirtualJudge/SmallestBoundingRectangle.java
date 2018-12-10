package ProblemsIn_Java.VirtualJudge;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.List;

public class SmallestBoundingRectangle {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String args[]) throws Exception {

        int n;
        while ((n = Integer.parseInt(in.readLine().trim())) != 0) {
            double points[][] = new double[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                points[i][0] = Double.parseDouble(st.nextToken());
                points[i][1] = Double.parseDouble(st.nextToken());
            }
            points = convexHullGS(points, true);

        }
        out.close();
        in.close();
    }
    static int sgn(double x) {
        return Math.abs(x) > 9.9e-12 ? (x < 0 ? -1 : 1) : 0;
    }

    static double cruz(double[] a, double[] b) {
        return a[0] * b[1] - a[1] * b[0];
    }

    static double cruz(double[] a, double[] b, double[] c) {
        return cruz(a, b) + cruz(b, c) + cruz(c, a);
    }

    static double[][] convexHullGS(double[][] pt, boolean bd) { // bd: con borde?
        int h = pt.length, i = h, t = 0;
        double v[] = null, w[], r[][] = new double[h][];
        for (double[] p : pt) if (v == null || p[1] < v[1] || (p[1] == v[1] && p[0] > v[0])) v = p;
        v = v.clone();
        for (double[] p : pt) {
            p[0] -= v[0];
            p[1] -= v[1];
        }
        Arrays.sort(pt, new Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                double cz = cruz(b, a);
                return sgn(sgn(cz) != 0 ? cz : a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
            }
        });
        if (bd) while (i - 1 >= 0 && cruz(pt[h - 1], pt[i - 1]) == 0) i--;
        if (bd) for (int k = i; k < (i + h) / 2; k++) {
            w = pt[k];
            pt[k] = pt[h - 1 - k + i];
            pt[h - 1 - k + i] = w;
        }
        for (double[] p : pt) {
            while (t >= 2 && sgn(cruz(r[t - 1], p, r[t - 2])) < (bd ? 0 : 1)) t--;
            r[t++] = p;
        }
        for (double[] p : pt) {
            p[0] += v[0];
            p[1] += v[1];
        }
        return Arrays.copyOfRange(r, 0, t);
    }

    //------------------------------------------------------------------------------------------------------------------

}
