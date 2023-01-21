/*
프로그래머스 lv1 부족한 금액 계산하기
*/

function solution(price, money, count) {
  var answer = -1;

  answer = Array(count).fill(price).map((d,index)=>d*(index+1)).reduce((pre,cur)=>pre+cur,0) - money
  if(answer <0){
      answer = 0
  }
  return answer;
}