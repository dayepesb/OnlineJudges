package ProblemsIn_Java.Notebook_Camus.Stringology;int[] D1;
int boyerMooreHorspool(String text, String pattern, int size) {
	char P[] = pattern.trim().toCharArray();
	char T[] = text.trim().toCharArray();
	int offSet = 0; int scan = 0; int last = P.length - 1;
	int maxOffSet = T.length - P.length;
	preBoyerMooreSuffixBad(P, size);
	while (offSet <= maxOffSet) {
		for (scan = last; P[scan] == T[scan + offSet]; scan--) {
			if (scan == 0) return offSet;
		}
		offSet += D1[T[offSet + last]];
	}
	return -1;
}
void preBoyerMooreSuffixBad(char P[], int size) {
	int m = P.length; int last = m - 1;
	D1 = new int[size]; Arrays.fill(D1, m);
	for (int i = 0; i < last; i++) {
		D1[P[i]] = last - i;
	}
}
