#include <bits/stdc++.h>

using namespace std;
int n, m, a , b, mx;
vector<int> v[10001];
int visited[10001], adj[10001]; 
//첫째 줄에, N과 M이 들어온다
//둘째 줄부터 M개의 줄에 신뢰하는 관계가 A B와 같은 형식으로 들어오며,
//"A가 B를 신뢰한다"

int dfs(int here){
	int ret = 1;
	visited[here] = 1;
	for(int there:v[here]){
		if(visited[there]) continue;
		ret += dfs(there);
	}
	return ret;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> n >> m;
	
	while(m--){
		cin >> a >> b;
		v[b].push_back(a);
	}
	
	for(int i=1; i<=n; i++){
		memset(visited, 0, sizeof(visited));
		adj[i] = dfs(i);
		mx = max(adj[i], mx);
	}
	
	for(int i=1; i<=n; i++){
		if(adj[i] == mx){
			cout << i << " ";
		}
	}
	
	return 0;
}
