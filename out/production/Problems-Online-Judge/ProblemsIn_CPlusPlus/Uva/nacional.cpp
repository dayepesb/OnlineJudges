//============================================================================
// Name        : nacional.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <stdio.h>
#include <algorithm>
#include <math.h>
using namespace std;

int main() {
	int nodes, edges, i, j, k, u, v, k2;
	double d, a1, a2, a3;
	while (scanf("%d %d", &nodes, &edges) != EOF) {
		double mAdy[nodes][nodes];
		for (i = 0; i < nodes; i++) {
			for (j = 0; j < nodes; j++) {
				mAdy[i][j] = 18000000.0;
			}
			mAdy[i][i] = 0.0;
		}
		for (i = 0; i < edges; ++i) {
			scanf("%d %d %lf", &u, &v, &d);
			mAdy[u][v] = mAdy[v][u] = d;
		}

		scanf("%lf %lf %lf", &a1, &a2, &a3);
		double torpe = min(a1, min(a2, a3));
		for (k = 0; k < nodes; k++) {
			for (i = 0; i < nodes; i++) {
				for (j = 0; j < nodes; j++) {
					mAdy[i][j] = min(mAdy[i][j], mAdy[i][k] + mAdy[k][j]);
				}
			}
		}

		double max = 0;
		for (k = 0; k < nodes; k++) {
			for (k2 = 0; k2 < nodes; k2++) {
				if (mAdy[k][k2] > max && mAdy[k][k2] != 18000000.0) {
					max = mAdy[k][k2];
				}
			}
		}

		double resp = ((ceil(max / torpe)));
		printf("%g\n",resp);

	}
	return 0;
}
