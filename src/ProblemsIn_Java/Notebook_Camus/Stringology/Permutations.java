package ProblemsIn_Java.Notebook_Camus.Stringology;void permutaciones(char[] perm, char[] sec, int[] used, int index) {
	if (index == perm.length) {
		String sal = "";
		for (int i = 0; i < perm.length; i++) { sal += perm[i]; }
		return;
	}
	for (int i = 0; i < used.length; i++) {
		if (used[i] != 0) {
			perm[index] = sec[i]; used[i]--;
			permutaciones(perm, sec, used, index + 1);
			used[i]++;
		}
	}
}