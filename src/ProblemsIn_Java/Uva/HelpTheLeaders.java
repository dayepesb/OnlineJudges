package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class HelpTheLeaders {

    static ArrayList <String> topics, denied, bitsNumbers;
    static HashMap<String, Integer> indexWords;

    public static void main (String [] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int cases = Integer.parseInt(in.readLine());
        for( int i = 1; i <= cases ; i++) {

            topics = new ArrayList<>();
            indexWords = new HashMap<>();
            denied = new ArrayList<>();
            bitsNumbers = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(in.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            for (int j = 0; j < t; j++) {
                String topic = in.readLine().trim().toUpperCase();
                bitsNumbers.add(Long.toBinaryString(1<<j));
                indexWords.put(topic,j);
                topics.add(topic);
            }

            Collections.sort(topics, (o1, o2) -> Integer.compare(o1.length(), o2.length()));

            for (int j = 0 ; j < p ; j++){
                st = new StringTokenizer(in.readLine());
                String a  = st.nextToken();
                String b = st.nextToken();


            }

        }
        in.close();
        out.close();
    }

}
