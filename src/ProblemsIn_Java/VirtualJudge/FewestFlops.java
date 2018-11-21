package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FewestFlops {
    static final int INF = (int) 1e9;
    static int[] chunks, f[], memo[];
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int tc = Integer.parseInt(in.readLine().trim());
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int k = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            N = s.length() / k;
            f = new int[27][N];
            for (int i = 0; i < N; ++i)
                for (int j = 0; j < k; ++j)
                    f[s.charAt(i * k + j) - 'a'][i]++;
            chunks = new int[N];
            for (int i = 0; i < N; ++i) {
                int count = 0;
                for (int j = 0; j < 26; ++j)
                    if (f[j][i] != 0)
                        ++count;
                chunks[i] = count;
            }

            memo = new int[27][N];
            for (int i = 0; i < 27; ++i)
                Arrays.fill(memo[i], -1);
            out.println(solution(26, 0));
        }
        out.close();
        in.close();
    }

    static int solution(int c, int idx) {
        if (idx == N)
            return 0;
        if (memo[c][idx] != -1)
            return memo[c][idx];
        int ret = INF, minus = f[c][idx] != 0 ? 1 : 0, chs = chunks[idx];
        for (int i = 0; i < 26; ++i)
            if (f[i][idx] != 0)
                ret = Math.min(ret, chs - (chs > 1 && i == c || chs == 1 && i != c ? 0 : minus) + solution(i, idx + 1));
        return memo[c][idx] = ret;
    }
}
