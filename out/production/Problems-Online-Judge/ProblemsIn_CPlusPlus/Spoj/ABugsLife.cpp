#include<cstdio>
#include<iostream>
#include<vector>


using namespace std;

int n,m;
vector<int> ady [2001];
int sexo[2001];

bool dfs(int v){
	bool hetero = true;
	for(int i = 0; i < ady[v].size();i++){
		int w = ady[v][i];
		if(sexo[w]==sexo[v])return false;
		if(sexo[w]==0){
			sexo[w]=(sexo[v]*-1);
			hetero = (hetero and dfs(w));
		}
	}
	return hetero;
}

int main(int argc, char *argv[])
{
	int t;
	scanf("%d",&t);
	for(int c = 1;c<=t;c++){
		scanf("%d %d",&n,&m);
		int x,y;
		//memset(sexo,0,sizeof(sexo));
		for(int i = 0 ; i < n ; i++){
			sexo[i]=0;
			ady[i].clear();
		}
		for(int i = 0 ; i < m ; i++){
			scanf("%d %d",&x,&y);
			ady[x].push_back(y);
			ady[y].push_back(x);
		}
		bool hetero = true;
		for(int i = 1 ; i <= n ;  i++){
			if(sexo[i]==0){
				sexo[i]=1;
				hetero = (hetero and dfs(i));
				if(!hetero)break;

			}
		}
		printf("Scenario #%d:\n",c);
		if(!hetero){printf("Suspicious bugs found!");}
		else{printf("No suspicious bugs found!");}
	}
	return 0;
}
