package ProblemsIn_Java.Notebook_Camus.SortAndSearch;

public boolean BinarySearch(int[] a, int s, int e, int b) {
	while (s <= e) {
		int middle = a[(s + e) / 2];
		if (middle == b) { return true;
		} else if (middle < b) { s = ((s + e) / 2) - 1;
		} else { e = ((s + e) / 2) - 1; }
	}
	return false;
}
