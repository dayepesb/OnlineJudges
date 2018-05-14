package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

/**
 * @author David Yepes Buitrago
 *
 * @Date 28-07-2017
 */
public class DesingTShirts {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int n;
		for (String line; !(line = in.readLine().trim()).equals("-1");) {
			n = Integer.parseInt(line);
			trie = new Node[500000];
			for (int i = 0; i < 500000; trie[i] = new Node(), i++)
				;
			trie[0].init();
			count = 0;
			gIndex = 0;
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < n; ++i) {
				String s = st.nextToken();
				insert(s, 1);
			}
			ans = 0;
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < n; ++i) {
				insert(st.nextToken(), 2);
			}
			query(0, 0);
			out.println(ans);
		}

		in.close();
		out.close();
	}

	static class Node {
		HashMap<Character, Integer> children;
		int first = 0;
		int second = 0;

		public Node() {
			children = new HashMap<>();
		}

		void init() {
			children.clear();
			first = 0;
			second = 0;
		}
	}

	static final int MAX = 500000;
	static int gIndex;
	static Node trie[];
	static int count = 0;

	public static void insert(String s, int type) {
		int cIndex = 0;

		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			Integer nIndex = trie[cIndex].children.get(c);
			if (nIndex == null) {
				trie[cIndex].children.put(c, ++gIndex);
				if (trie[gIndex] == null)
					trie[gIndex] = new Node();
				trie[gIndex].init();
				cIndex = gIndex;
				nIndex = cIndex;
			} else {
				cIndex = nIndex;
			}

			if (type == 1)
				trie[nIndex].first++;
			else
				trie[nIndex].second++;
		}
	}

	static int ans = 0;

	public static int query(int cIndex, int depth) {

		int sub = 0;
		for (Entry<Character, Integer> me : trie[cIndex].children.entrySet()) {
			int value = me.getValue();

			if (trie[value].first > 0 && trie[value].second > 0) {
				int r = query(value, depth + 1);
				sub += r;
				trie[cIndex].first -= r;
				trie[cIndex].second -= r;
			}
		}
		int min = Math.min(trie[cIndex].first, trie[cIndex].second);
		if (cIndex != 0)
			ans += depth * min;
		return min + sub;
	}

}
