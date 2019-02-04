package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class ZipfsLaw {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine().trim());
        HashMap<String, Integer> map;
        StringTokenizer st;
        in.readLine();
        String line;
        try {
            while ((line = in.readLine().trim()) != null)
                while (!(line = in.readLine().trim()).equals("")) {
                    map = new HashMap<>();
                    st = new StringTokenizer(line);
                    while (st.hasMoreTokens()) {
                        String word = st.nextToken();
                        if (!map.containsKey(word)) map.put(word.toLowerCase(), 1);
                        int aux = map.get(word) + 1;
                        map.put(word, aux);
                    }
                    int count = 0;
                    for (Map.Entry<String, Integer> m : map.entrySet())
                        if (m.getValue() == n) out.println(m.getKey());
                }
        } catch (Exception e) {
        }

        out.close();
        in.close();
    }
}
