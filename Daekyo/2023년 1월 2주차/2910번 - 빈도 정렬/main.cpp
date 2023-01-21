#include <bits/stdc++.h>
using namespace std;  
int n, c, a[1004];
map <int, int> mp, mp_first;
vector <pair<int, int>> v;
//빈도정렬
// X가 Y보다 수열에서 많이 등장하는 경우에는 X가 Y보다 앞 
//(1순위 counting)

//등장하는 횟수가 같다면, 먼저 나온 것이 앞에 있어야 한다.
//first (2순위) 

bool cmp(pair<int, int> a, pair<int, int> b){
	
	if(a.first == b.first){
		return mp_first[a.second] < mp_first[b.second]; 
	}
	return a.first > b.first;
} 
int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
    //첫째 줄에 메시지의 길이 N과 C가 
    cin >> n >> c;
    for(int i=0; i<n; i++){
    	cin>> a[i];
    	mp[a[i]]++;
    	if(mp_first[a[i]]==0) mp_first[a[i]] = i+1;
	}
	
	for(auto it: mp){
		v.push_back({it.second, it.first});
	}
	
	sort(v.begin(), v.end(), cmp);
	
	for(auto i: v){
		for(int j=0; j<i.first; j++){
			cout << i.second << " ";
		}
	}
	return 0;
}
