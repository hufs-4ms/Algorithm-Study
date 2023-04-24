/*
lv2  n개의 최소공배수
*/
function solution(arr) { 
  var answer = 0;
  let tmp = 0
  while(!answer){
      let n = 0
      tmp++
      for(let i=0;i<arr.length;i++){
          if(tmp%arr[i]===0){
              n++
          }
      }
      if(n===arr.length){
          answer = tmp
      }
  }
  return answer;
}
function gcd