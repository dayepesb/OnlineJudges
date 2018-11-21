    package ProblemsIn_Java.VirtualJudge;

    import java.awt.geom.Point2D;
    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.io.PrintWriter;
    import java.util.Arrays;
    import java.util.StringTokenizer;

    public class BeyBattle {
        static Point2D[] points;
        static double respuesta;
        public static void main(String[] args) throws Exception {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(System.out);

            try {
                for (String line; (line = in.readLine()) != null; ) {
                    int n = Integer.parseInt(line.trim());
                    points = new Point2D[n];
                    for (int i = 0; i < n; i++) {
                        StringTokenizer st = new StringTokenizer(in.readLine());
                        points[i] = new Point2D.Double(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                    }
                    Arrays.sort(points, (x, y) -> {
                        if (x.getX() != y.getX()) return Double.compare(x.getX(), y.getX());
                        return Double.compare(x.getY(), y.getY());
                    });
    //                for (Point2D d: points) {
    //                    System.out.println(d);
    //                }
                    respuesta = Integer.MAX_VALUE / 2;
                    closestPair(0, n - 1);
                    out.println((int) respuesta);
                }
            } catch (Exception e) {
            }
            out.close();
            in.close();
        }
        static void closestPair(int l, int r) {
            if (l >= r) return;
            int m = (l + r) / 2;
            closestPair(l, m);
            closestPair(m + 1, r);
            int i, j;
    //        Miro izquierda
            for (i = m; i >= l; i--) {
    //            Si se excede la diff
                if (points[m].getX() - points[i].getX() >= respuesta)
                    break;
    //            miro der
                for (j = m + 1; j <= r; j++) {
                    if (points[j].getX() - points[i].getX() >= respuesta)
                        break;
                    respuesta = Math.min(respuesta, Math.max(points[j].getX() - points[i].getX(), Math.abs(points[j].getY() - points[i].getY())));
                }
            }
        }
    }
