/*
lv1 없는 숫자 더하기
*/
function solution(numbers) {
  var answer = -1;
  
  const sum = numbers.reduce((pre,cur)=>pre+cur,0)
  answer = 45 - sum
  return answer;
}