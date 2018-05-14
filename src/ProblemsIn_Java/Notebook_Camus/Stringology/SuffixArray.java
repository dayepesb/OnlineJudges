package ProblemsIn_Java.Notebook_Camus.Stringology;

public class sufixArray {
	public static void main(String[] args) {
		String s = "banana" + (char) 0;
		Integer[] sa = suffix_array(s);
		for (int x : sa)
			System.out.println(s.substring(x, s.length()) + " ");
		System.out.println();
		int[] lcp = lcp_array(sa, s);
		for (int x : lcp)
			System.out.print(x + " ");
		System.out.println();
	}
	private static int[] lcp_array(Integer[] sa, String s) {
		int n = s.length();
		int[] rank = new int[n];
		for (int i = 0; i < n; i++) rank[sa[i]] = i;
		int[] ans = new int[n];
		for (int i = 0, l = 0; i < n; i++)
			if (rank[i] > 0) {
				int j = sa[rank[i] - 1];
				while (s.charAt(i + l) == s.charAt(j + l)) l++;
				ans[rank[i]] = l > 0 ? l-- : l;
			}
		return ans;
	}
	private static Integer[] suffix_array(String s) {
		int n = s.length(); Integer sa[] = new Integer[n];
		Arrays.fill(sa, 0); int rank[] = new int[n];
		long rank2[] = new long[n];
		for (int i = 0; i < n; i++) {
			sa[i] = i; rank[i] = s.charAt(i);
		}
		for (int len = 1; len < n; len *= 2) {
			for (int i = 0; i < n; i++)
				rank2[i] = ((long) rank[i] << 32) + (i + len < n ? rank[i + len] : -1);
			Arrays.sort(sa, (Integer i, Integer j) -> comp(rank2[i] - rank2[j]));
			for (int i = 0; i < n; i++) {
				if (i > 0 && rank2[sa[i]] == rank2[sa[i - 1]])
					rank[sa[i]] = rank[sa[i - 1]];
				else
					rank[sa[i]] = i;
			}
		}
		return sa;
	}
	static int comp(long l) {
		l = Math.min(l, 1); l = Math.max(l, -1);
		return (int) l;
	}
}
