/*
프로그래머스 lv1 예산
*/

function solution(d, budget) {
  var answer = 0;
  answer = d.sort((a,b)=>a-b).map(d => budget-=d).findIndex(e=>e<0)
  answer = answer==-1 ? d.length : answer 
  return answer;
}