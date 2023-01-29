/*
lv1 문자열 다루기 기본
*/
function solution(s) {
  var answer = false;
  
  if(s.length==4 || s.length==6){
      if(!isNaN(s)){
          answer = true
      }
      if(s.split('').includes('e')){
          answer = false
      }
  }
  return answer;
}