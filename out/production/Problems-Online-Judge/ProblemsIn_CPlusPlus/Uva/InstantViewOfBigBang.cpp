#include <cstdio>
#include <cstring>
#include <algorithm>
#include <queue>

using namespace std;

const int N = 1010;

struct Edge {
	int v, dis, next;
	Edge(int v, int dis, int next) :
			v(v), dis(dis), next(next) {
	}
} E[N * 2];

int head[N], cnt[N], d[N], ans[N];
bool vis[N], cycle[N];
int n, m, num, cas = 1;

void init() {
	memset(head, -1, sizeof(head));
	scanf("%d%d", &n, &m);

	int u, v, dis;
	for (int i = 0; i < m; i++) {
		scanf("%d%d%d", &u, &v, &dis);
		E[i] = Edge(u, dis, head[v]);
		head[v] = i;
	}
}

void dfs(int u) {
	cycle[u] = true;
	ans[num++] = u;
	for (int i = head[u]; ~i; i = E[i].next) {
		int v = E[i].v;
		if (cycle[v])
			continue;
		dfs(v);
	}
}

void solve() {
	queue<int> Q;
	num = 0;
	for (int i = 0; i < n; i++) {
		d[i] = cnt[i] = 0;
		vis[i] = true;
		cycle[i] = false;
		Q.push(i);
	}

	while (!Q.empty()) {
		int u = Q.front();
		Q.pop();
		vis[u] = false;

		for (int i = head[u]; ~i; i = E[i].next) {
			int v = E[i].v;
			if (cycle[v])
				continue;
			if (d[v] > d[u] + E[i].dis) {
				d[v] = d[u] + E[i].dis;
				if (!vis[v]) {
					vis[v] = true;
					Q.push(v);
					if (++cnt[v] >= n) {
						dfs(v);
					}
				}
			}
		}
	}
	if (num == 0)
		printf("Case %d: impossible\n", cas++);
	else {
		printf("Case %d:", cas++);
		sort(ans, ans + num);
		for (int i = 0; i < num; i++)
			printf(" %d", ans[i]);
		printf("\n");
	}
}

int main() {
	int test;
	scanf("%d", &test);
	while (test--) {
		init();
		solve();
	}
	return 0;
}
