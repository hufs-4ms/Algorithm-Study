/*
lv1 정수 내림차순 배치하기
*/
function solution(n) {
  var answer = String(n).split('').sort().reverse().join('')
  answer*=1
  return answer;
}