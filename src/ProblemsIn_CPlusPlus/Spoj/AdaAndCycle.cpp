#include<cstdio>
#include<cstring>
#include<cmath>
#include<cstdlib>
#include<queue>
#include<algorithm>
#include<vector>

#define ll long long
#define maxn 1000007  // 1e6+7

using namespace std;
vector<int> edge[2010];

int vis[2010];

struct node {
	int to, step;
} cur;

int n;

int bfs(int x, int step) {
	queue<node> q;
	cur.to = x;
	cur.step = step;
	q.push(cur);
	memset(vis, 0, sizeof(vis));
	int xx;

	while (!q.empty()) {
		cur = q.front();
		xx = cur.to;
		step = cur.step;

		q.pop();

		int tmp = edge[xx].size();
		int tmp2;
		for (int i = 0; i < tmp; i++) {
			tmp2 = edge[xx][i];
			if (vis[tmp2] == 0) {
				if (tmp2 == x)
					return step + 1;

				if (step >= n)
					continue;

				vis[tmp2] = 1;
				cur.to = tmp2;
				cur.step = step + 1;
				q.push(cur);
			}
		}
	}

	return 0;
}

int main() {

	scanf("%d", &n);
	int tmp;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++) {
			scanf("%d", &tmp);
			if (tmp == 1) {
				edge[i].push_back(j);
			}
		}

	int ans;
	for (int i = 0; i < n; i++) {
		ans = 0;
		if (edge[i].size())  // ??
			ans = bfs(i, 0);
		if (ans == 0)
			printf("NO WAY\n");
		else
			printf("%d\n", ans);
	}
	return 0;
}
