/*
lv1 핸드폰 번호 가리기
*/

function solution(phone_number) {
  var answer = phone_number.slice(0,phone_number.length-4).split('').map(d=>'*').join('').concat(phone_number.slice(phone_number.length-4))
  return answer;
}