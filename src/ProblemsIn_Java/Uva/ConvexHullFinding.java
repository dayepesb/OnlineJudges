package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class ConvexHullFinding {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int cases = Integer.parseInt(in.readLine().trim());

        out.println(cases);
        for (int i = 1; i<=cases ;i++ ){
            int points = Integer.parseInt(in.readLine().trim())-1;

            double pt  [][] = new double[points][2];

            for (int j = points-1 ; j >=0 ; j--) {
                StringTokenizer st = new StringTokenizer(in.readLine().trim());
                pt[j][0] = Double.parseDouble(st.nextToken());
                pt[j][1] = Double.parseDouble(st.nextToken());
            }

            double convex [][]= convexHullGS(pt,false);

            int index= findminus(convex);

            out.println(convex.length+1);
            int iter = 0;
            for (int j = index;true;j++) {

                if(j>=convex.length)
                    j%=convex.length;

                if(iter!=0 && j==index)
                    break;

                out.printf("%d %d\n",(int)(convex[j][0]),(int)(convex[j][1]));

                iter++;
            }
            out.printf("%d %d\n",(int)(convex[index][0]),(int)(convex[index][1]));

            in.readLine();

            if(i!=cases) {
                in.readLine();
                out.println(-1);
            }
        }

        in.close();
        out.close();
    }

    static int findminus(double pt [][]){
        long min = Long.MAX_VALUE;
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0 ; i  < pt.length; i++){
            min = Math.min(min,(int)pt[i][1]);
        }
        for (int i = 0 ; i  < pt.length; i++){
            if(min==(int)pt[i][1]){
                indexes.add(i);
            }
        }

        if(indexes.size()==1)
            return indexes.get(0);

        long min2 = Long.MAX_VALUE;
        List<Integer> indexes2 = new ArrayList<>();

        for (int i = 0 ; i  < indexes.size(); i++){
            min2 = Math.min(min2,(int)pt[indexes.get(i)][0]);
        }
        for (int i = 0 ; i  < indexes.size(); i++){
            if(min2==(int)pt[indexes.get(i)][0]){
                indexes2.add(i);
            }
        }

        for (int i = 0 ; i < pt.length;i++) {
            if (min2 == pt[i][0] && pt[i][1] == min)
                return i;
        }
        return 0;
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

    static double[][] convexHullGS(double[][] pt, boolean bd) {
        int h = pt.length, i = h, t = 0;
        double v[] = null, w[], r[][] = new double[h][];
        for (double[] p : pt)
            if (v == null || p[1] < v[1] || (p[1] == v[1] && p[0] > v[0]))
                v = p;
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
        if (bd)
            while (i - 1 >= 0 && cruz(pt[h - 1], pt[i - 1]) == 0)
                i--;
        if (bd)
            for (int k = i; k < (i + h) / 2; k++) {
                w = pt[k];
                pt[k] = pt[h - 1 - k + i];
                pt[h - 1 - k + i] = w;
            }
        for (double[] p : pt) {
            while (t >= 2 && sgn(cruz(r[t - 1], p, r[t - 2])) < (bd ? 0 : 1))
                t--;
            r[t++] = p;
        }
        for (double[] p : pt) {
            p[0] += v[0];
            p[1] += v[1];
        }
        return Arrays.copyOfRange(r, 0, t);
    }
}
