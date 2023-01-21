/*
프로그래머스 lv1 소수 만들기
*/
function solution(nums) {
  var answer = 0
  let start = 0
  let mid = 1
  let end = 2
  const size = nums.length
  while(size-start > 2 ){
      const number = nums[start]+nums[mid]+nums[end]
      
      if(isAnswer(number)){
          answer++
      }
      
      if(end==size-1){
          if(mid+1==size-1){
              start++
              mid = start+1
              end = start+2
          }else{
              mid++
              end = mid+1  
          }
      }else{
          end++
      }
  }
  return answer;
}
function isAnswer(num){
  for(let i=2;i<num;i++){
      if(num%i==0){
          return false
      }
  }
  return true
}
