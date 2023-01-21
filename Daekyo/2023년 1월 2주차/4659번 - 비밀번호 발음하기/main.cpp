#include <bits/stdc++.h>
using namespace std; 

//모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다. (function)
//모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
//같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
int lcnt, vcnt;
string s;

bool isVouml(int idx){
	return (idx == 'a' || idx == 'e' || idx == 'i' || idx == 'o'||idx == 'u');
}

int main(){
	//각 테스트 케이스는 한 줄(오직 소문자) 
	//마지막 테스트 케이스는 end
	while(true){
		cin >> s;
		if(s == "end") break;
		int flag = 0;
		lcnt = vcnt = 0;
		int inClude_v = 0;
		int prev = -1;
		for(int i=0; i<s.size(); i++){
			int idx = s[i];
			if(isVouml(idx)) lcnt++, vcnt = 0, inClude_v=1;
			else lcnt=0, vcnt++;
			if(lcnt==3 || vcnt==3) flag = 1;
			if(i >= 1 && (prev == idx) && (idx != 'e' && idx != 'o')) flag = 1;
			prev = idx;
		}
		if(flag == 1 || inClude_v==0) cout << "<" << s << ">" << " is not acceptable.\n";
	    else cout << "<" << s << ">" << " is acceptable.\n";
	}
	return 0;
}
