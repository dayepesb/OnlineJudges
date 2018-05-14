//============================================================================
// Name        : David.cpp
// Author      :
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <stdio.h>
#include <string.h>

using namespace std;

char text[100005];
char word[100005];
int t, k, n1, m1;

void functionZ(char cadena[], int type, int solve[]) {
	int lengt = m1 + n1 + 1;
	int z[lengt];
	for (int i = 0; i < lengt; i++) {
		z[i] = 0;
	}

	//funcion z
	int l = 0, r = 0, n = n1 + m1 + 1;
	for (int i = 1; i < n; i++) {
		if (i > r) {
			l = r = i;
			while (r < n && cadena[r - l] == cadena[r])
				r++;
			z[i] = r - l;
			r--;
		} else {
			int k = i - l;
			if (z[k] < r - i + 1)
				z[i] = z[k];
			else {
				l = i;
				while (r < n && cadena[r - l] == cadena[r])
					r++;
				z[i] = r - l;
				r--;
			}
		}
	}

	if (type == 1) {
		for (int i = 0; i < n1; i++) {
			solve[i] = z[i + m1 + 1];
		}
	} else {
		for (int i = 0, j = lengt - 1; i < n1; i++, j--) {
			solve[i] = z[j];
		}
	}
}
int main() {

	int t;
	scanf("%d", &t);
	while (t--) {
		scanf("%s", &text);
		scanf("%s", &word);
		scanf("%d", &k);
		n1 = strlen(text);
		m1 = strlen(word);
		char z1[n1 + m1 + 1], z2[n1 + m1 + 1];
		int index = 0;
		for (int i = 0, j = m1 - 1; i < m1; i++, j--) {
			z1[index] = word[i];
			z2[index++] = word[j];
		}
		z1[index] = z2[index] = '$';
		index++;
		for (int i = 0, j = n1 - 1; i < n1; i++, j--) {
			z1[index] = text[i];
			z2[index++] = text[j];
		}

		int solve_1[n1];
		functionZ(z1, 1, solve_1);
		int solve_2[n1];
		functionZ(z2, 2, solve_2);
		int s = n1, cont = 0,l = m1;
		k = l - k;
		for (int i = 0; i <= s - l; i++) {
			if ((solve_1[i] + solve_2[i + l - 1]) >= k) {
				cont++;
			}
		}
		printf("%d\n",cont);
	}

	return 0;
}

