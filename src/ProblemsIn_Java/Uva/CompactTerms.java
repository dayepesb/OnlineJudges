package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago	
 * @date 00-00-0000
 * @time 0.000 ms
 */
public class CompactTerms {
	static HashMap<String, Integer> index;
	static int k;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int a[][] = new int[1000000000][1000000000];
		for (String line; (line = in.readLine()) != null;) {
			line = line.trim();
			index = new HashMap<>();
			k = 0;
			System.out.println(build(line));
			System.out.println(index);
			out.println(index.size() == 0 ? 1 : index.size());
		}

		in.close();
		out.close();
	}

	static String build(String tree) {
		StringBuilder sb = new StringBuilder(), childs = new StringBuilder();
		String r;
		for (int i = 0; i < tree.length(); i++) {
			if (tree.charAt(i) == '(') {
				r = sb.toString();
				boolean b = false;
				boolean one = false;
				int n = 0, indexS = i + 1;
				childs.append(r + "(");
				for (int j = i + 1; j < tree.length(); j++) {
					if (tree.charAt(j) == '(') {
						b = true;
						n++;
					} else if (tree.charAt(j) == ')') {
						n--;
					}
					if (n == 0 && b) {
						StringBuilder child = new StringBuilder(tree.substring(indexS, j + 1));
						if (child.charAt(0) == ',')
							child = new StringBuilder(child.substring(1, child.length()));
						childs.append(build(child.toString()) + ",");
						b = false;
						one = true;
						n = 0;
						indexS = j + 1;
					}
				}
				if (one) {
					StringBuilder s = new StringBuilder(childs.toString().substring(0, childs.length() - 1));
					s.append(")");
					childs = new StringBuilder(s);
					if (!index.containsKey(childs.toString())) {
						index.put(childs.toString(), k);
						k++;
					}
				}
				// si es una hoja
				if (!one) {
					StringTokenizer st = new StringTokenizer(tree.substring(i + 1, tree.length() - 1), ",");
					StringBuilder sb2 = new StringBuilder();
					while (st.hasMoreTokens()) {
						String child = st.nextToken().trim();
						if (!index.containsKey(child)) {
							index.put(child, k);
							k++;
						}
						sb2.append("," + index.get(child));
					}
					sb2 = new StringBuilder(r + "(" + sb2.toString().substring(1));
					sb2.append(")");
					if (!index.containsKey(sb2.toString())) {
						index.put(sb2.toString(), k);
						k++;
					}
					return index.get(sb2.toString()) + "";
				}
				break;
			} else {
				sb.append(tree.charAt(i));
			}
		}
		return index.get(childs.toString()) + "";
	}
}
