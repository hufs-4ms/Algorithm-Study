/*
lv1 콜라스 추측
*/
function solution(num) {
  var answer = 0;
  
  if(num==1){
      answer = 0
  }else{
      answer = recur(num,0)
  }
  
  
  return answer;
}
function recur(num,n){
  if(num==1){
      return n
  }
  if(n==501){
      return -1
  }
  
  if(num%2==0){
      num=num/2
  }else{
      num = num*3+1
  }
  return recur(num,++n)
}