/*
lv1  하샤드 수
*/
function solution(x) {
  var answer = false;
  let arr = String(x).split('')
  
  let sum = arr.reduce((pre,cur)=>Number(cur)+Number(pre),0)

  if(x%sum==0){
      answer = true
  }else{
      answer=false
  }
  return answer;
}