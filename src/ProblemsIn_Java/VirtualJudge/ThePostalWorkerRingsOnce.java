package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ThePostalWorkerRingsOnce {

    static final int INF = Integer.MAX_VALUE;
    static long[] mAdy[], degree;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        for (String line; (line = in.readLine()) != null; ) {


            //read

            mAdy = new long[30][30];
            degree = new long[30];
            for (int i = 0; i < 27; i++) {
                for (int j = 0; j < 30; j++)
                    mAdy[i][j] = INF;
                mAdy[i][i] = 0;
            }
            int sum = 0;
            int u = line.trim().charAt(0) - 'a';
            int l = line.trim().length();
            sum += l;
            int v = line.trim().charAt(l - 1) - 'a';
            mAdy[u][v] = mAdy[v][u] = l;
            degree[u]++;
            degree[v]++;
            while (true) {
                line = in.readLine().trim();
                if (line.equalsIgnoreCase("deadend"))
                    break;
                u = line.charAt(0) - 'a';
                l = line.length();
                v = line.charAt(l - 1) - 'a';
                mAdy[u][v] = mAdy[v][u] = l;
                sum += l;
                degree[u]++;
                degree[v]++;
            }

            solve(sum);
        }
        out.close();
        in.close();
    }

    private static void solve(int sum) {
        int od1 = -1, od2 = -1;
        for (int i = 0; i < 30; i++)
            if (degree[i] % 2 == 1) {
                od1 = i;
                break;
            }

        for (int i = 29; i > 0; i--)
            if (degree[i] % 2 == 1) {
                od2 = i;
                break;
            }
        if (od1 < 0 && od2 < 0) {
            out.println(sum);
            return;
        }

        //floyd
        for (int k = 0; k < 27; k++)
            for (int i = 0; i < 27; i++)
                for (int j = 0; j < 27; j++)
                    if (mAdy[i][j] > mAdy[i][k] + mAdy[k][j])
                        mAdy[i][j] = mAdy[i][k] + mAdy[k][j];

        out.println(mAdy[od1][od2] + sum);
    }
}
