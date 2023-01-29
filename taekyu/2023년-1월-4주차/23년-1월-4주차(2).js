/*
lv1 약수의 개수와 덧셈
*/
function solution(left, right) {
  var answer = 0;
  
  for(let i=left; i<right+1;i++){
      let tmp = 0
      for(let j=1;j<i+1;j++){
          if(i%j==0){
              tmp++
          }
      }

      if(tmp%2==0){
          answer += i
      }else{
          answer -= i
      }
  }
  
  return answer;
}