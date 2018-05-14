#include<cstdio>
#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

struct action {
	int start, end;
};

bool compare(action a, action b) {
	if (a.end < b.end) {
		return true;
	}
	if (a.end == b.end) {
		return (a.start < b.start);
	}
	return false;
}

int main() {

	int cases;
	scanf("%d", &cases);
	while (cases>0) {
		cases--;
		int n;
		scanf("%d", &n);
		action arr[n];
		for (int i = 0; i < n; i++) {
			int a, b;
			scanf("%d %d", &a, &b);
			arr[i].start = a;
			arr[i].end = b;
		}
		sort(arr, arr + n, compare);
		int cont = 0;
		int time = -1;
		for (int i = 0; i < n; i++)
			if (arr[i].start >= time) {
				cont += 1;
				time = arr[i].end;
			}
		printf("%d\n", cont);

	}
	return 0;
}

