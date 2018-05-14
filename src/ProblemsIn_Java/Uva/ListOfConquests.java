package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ListOfConquests {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int lines;
		String name;
		StringTokenizer st;
		Map<String, Integer> map = new TreeMap<>();

		lines = Integer.parseInt(in.readLine());
		for (int i = 0; i < lines; i++) {
			st = new StringTokenizer(in.readLine());
			name = st.nextToken();
			if (map.containsKey(name)) {
				map.put(name, map.get(name) + 1);
			} else {
				map.put(name, 1);
			}
		}
		 for (Entry<String, Integer> m : map.entrySet()) {
		 out.println(m.getKey()+" "+m.getValue());
		 }


		out.close();
		in.close();
	}

}
