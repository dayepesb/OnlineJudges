#include <stdio.h>
#include <string.h>

double t1, t2, t3, t4, t5;

bool toSeconds(double &t) {
	double h, m, s;
	if (scanf("%lf:%lf:%lf", &h, &m, &s) != 3 || h < 0) {
		return false;
	}
	t = h * 3600 + m * 60 + s;
	return true;
}

int main() {
	while (toSeconds(t1)) {
		toSeconds(t2);
		toSeconds(t3);
		toSeconds(t4);
		toSeconds(t5);
		double k = (t5 - t2) * (t3 - t1) / (t4 - t1) / (t3 - t2);
		int t = (int) ((t4 * k - t5) / (k - 1) + 1e-6 + 0.5);
		printf("%02d:%02d:%02d\n", t / 3600, t % 3600 / 60, t % 3600 % 60);
	}
	return 0;
}
