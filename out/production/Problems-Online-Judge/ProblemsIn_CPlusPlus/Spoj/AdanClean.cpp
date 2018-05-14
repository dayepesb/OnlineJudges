/*
 * AdanClean.cpp
 *
 *  Created on: 24 jun. 2017
 *      Author: david
 */

#include <iostream>
#include <string>
#include <map>

using namespace std;

long tamHash(string txt);
long hashOne(string txt);

long PRIME = 1000000007;
long RM;
long R = 26;
int N, M;

int main() {
	int casos;
	cin >> casos;

	for (int i = 0; i < casos; i++) {
		cin >> N;
		cin >> M;
		RM = 1;
		for (int j = 1; j <= M - 1; j++) {
			RM = (R * RM) % PRIME;
		}
		string txt;
		cin>>txt;

		cout<<tamHash(txt)<<endl;
	}

	return 0;
}

long tamHash(string txt) {
	map<long, long> ts;
	long txtHash = hashOne(txt);
	ts[txtHash] = txtHash;

	for (int i = 1; i <= N - M; i++) {
		txtHash = (txtHash + PRIME - RM * txt.at(i - 1) % PRIME) % PRIME;
		txtHash = (txtHash * R + txt.at(i + M - 1)) % PRIME;
		ts[txtHash] = txtHash;
	}

	return ts.size();
}

long hashOne(string key) {
	long h = 0;
	for (int j = 0; j < M; j++) {
		h = (R * h + key.at(j)) % PRIME;
	}
	return h;
}
