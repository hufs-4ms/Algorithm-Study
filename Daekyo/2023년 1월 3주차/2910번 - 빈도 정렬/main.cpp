#include <bits/stdc++.h>
using namespace std;  
int n, c, a[1004];
map <int, int> mp, mp_first;
vector <pair<int, int>> v;
//������
// X�� Y���� �������� ���� �����ϴ� ��쿡�� X�� Y���� �� 
//(1���� counting)

//�����ϴ� Ƚ���� ���ٸ�, ���� ���� ���� �տ� �־�� �Ѵ�.
//first (2����) 

bool cmp(pair<int, int> a, pair<int, int> b){
	
	if(a.first == b.first){
		return mp_first[a.second] < mp_first[b.second]; 
	}
	return a.first > b.first;
} 
int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
    //ù° �ٿ� �޽����� ���� N�� C�� 
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
