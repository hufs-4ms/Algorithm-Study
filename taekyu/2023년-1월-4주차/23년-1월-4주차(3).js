/*
lv1 문자열 내림차순으로 배치하기
*/
function solution(s) {
  var answer = '';
  answer = s.split('').sort().reverse().join('')
  return answer;
}