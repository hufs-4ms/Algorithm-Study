/*
프로그래머스 lv 1 숫자 문자열과 영단어
*/

function solution(s) {
  var answer = 0;
  answer = s.replaceAll('zero',0).replaceAll('one',1).replaceAll('two',2).replaceAll('three',3)
      .replaceAll('four',4).replaceAll('five',5).replaceAll('six',6).replaceAll('seven',7)
      .replaceAll('eight',8).replaceAll('nine',9)
  answer *= 1
  return answer;
}