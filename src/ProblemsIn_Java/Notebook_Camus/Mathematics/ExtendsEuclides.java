package ProblemsIn_Java.Notebook_Camus.Mathematics;long[] extendsEuclides(int a, int b) {
	long[] res = new long[3];
	if ((b == 0)) {
		res[0] = a; res[1] = 1; res[2] = 0;
		return res; }
	int q = a / b; int r = a - b * q;
	long arr[] = extendsEuclides(b, r);
	long x = arr[1]; long y = arr[2];
	long d = arr[0]; res[0] = arr[0];
	res[1] = y; res[2] = x - q * y;
	return res;}