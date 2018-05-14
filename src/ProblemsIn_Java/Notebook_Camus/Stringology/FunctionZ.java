package ProblemsIn_Java.Notebook_Camus.Stringology;

public static int[] z(int f, String cad) {
	int[] z = new int[cad.length()];
	int l = 0, r = 0, n = cad.length();
	for (int i = 1; i < n; i++) {
		if (i > r) {
			l = r = i;
			while (r < n && cad.charAt(r - l) == cad.charAt(r))
				r++;
			z[i] = r - l;
			r--;
		} else {
			int k = i - l;
			if (z[k] < r - i + 1)
				z[i] = z[k];
			else {
				l = i;
				while (r < n && cad.charAt(r - l) == cad.charAt(r))
					r++;
				z[i] = r - l;
				r--;
			}
		}
	}
	return Arrays.copyOfRange(z, f, z.length);
}
