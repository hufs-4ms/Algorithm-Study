#include<bits/stdc++.h>
using namespace std;
int n, m; 
string s;
map<int, string> mp;
map<string, int> mp2;
int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> n >> m;
	for(int i=0; i<n; i++){
		cin >> s;
		mp[i+1] = s;
		mp2[s] = i+1; 
	}
	
	for(int i=0; i<m; i++){
		cin >> s;
		//입력 받은 것이 문자열이면 
		if(atoi(s.c_str())==0){
			cout << mp2[s] << "\n";
		}
		else{
			cout << mp[atoi(s.c_str())] << "\n";
		}
	}
	
	return 0;
	
	

}
