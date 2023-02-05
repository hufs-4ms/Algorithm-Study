/*
lv1 수박수박수박수박수박수?
*/
function solution(n) {
  var answer = '';
  
  answer = n%2==0 ? "수박".repeat(n/2) : "수박".repeat(Math.floor(n/2))+"수" 

  return answer;
}