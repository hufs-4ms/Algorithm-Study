/*
lv1 가운데 글자 가져오기
*/
function solution(s) {
  var answer = '';
  let size = s.length
  
  answer = size%2!=0 ? s[Math.floor(size/2)]: s[size/2-1]+s[size/2]
  
  return answer;
}