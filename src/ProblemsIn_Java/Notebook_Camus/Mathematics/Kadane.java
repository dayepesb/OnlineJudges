package ProblemsIn_Java.Notebook_Camus.Mathematics;

public long kadane(long[] arr) { // mayor suma en un arreglo
	long act = 0, r = Long.MIN_VALUE;
	for (long v : arr) {
		act += v;
		if (act > r) r = act;
		if (act < 0) act = 0;
	}
	return r;
}
