#include <bits/stdc++.h>
using namespace std;
int n, m ,cnt, cnt2;
int a[104][104], visited[104][104];
int dy[] = {-1, 0, 1, 0}, dx[] = {0, 1, 0, -1};
vector<pair<int, int>> v;
void go(int y, int x){
	visited[y][x] = 1;
	if(a[y][x]==1){
		v.push_back({y,x});
		return;
	}
	for(int i=0; i<4; i++){
		int ny = y + dy[i];
		int nx = x + dx[i];
		if(ny<0||ny>=n||nx<0||nx>=m||visited[ny][nx]) continue;
		visited[ny][nx] = 1;
		go(ny, nx);
	}
	return;
}

int main(){
	cin>>n>>m;
	
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			cin>>a[i][j];
		}
	}
	
	while(true){
		cnt = 0;
		fill(&visited[0][0], &visited[0][0] + 104*104, 0);
		v.clear();
		go(0,0);
		
		for(pair<int, int> b: v){
			cnt++;
			a[b.first][b.second] = 0;
		}
		
		bool check= 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(a[i][j]!=0) check = 1;
			}
		}
		cnt2++;
		if(!check) break;
	}
	
	cout <<cnt2 << "\n" << cnt  << "\n";
	return 0;
	
}
