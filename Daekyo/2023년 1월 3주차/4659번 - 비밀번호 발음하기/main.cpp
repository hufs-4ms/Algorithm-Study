#include <bits/stdc++.h>
using namespace std; 

//����(a,e,i,o,u) �ϳ��� �ݵ�� �����Ͽ��� �Ѵ�. (function)
//������ 3�� Ȥ�� ������ 3�� �������� ���� �� �ȴ�.
//���� ���ڰ� ���������� �ι� ���� �ȵǳ�, ee �� oo�� ����Ѵ�.
int lcnt, vcnt;
string s;

bool isVouml(int idx){
	return (idx == 'a' || idx == 'e' || idx == 'i' || idx == 'o'||idx == 'u');
}

int main(){
	//�� �׽�Ʈ ���̽��� �� ��(���� �ҹ���) 
	//������ �׽�Ʈ ���̽��� end
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
