/*
lv1  문자열 정수로 바꾸기
*/
function solution(s) {
  var answer = 0;
  if(s.includes('+')){
      answer = parseInt(s.split('+')[1])
  }
  if(s.includes('-')){
      answer='-'+parseInt(s.split('-')[1])
  }
  answer = parseInt(s)
  console.log(answer)
  return answer;
}