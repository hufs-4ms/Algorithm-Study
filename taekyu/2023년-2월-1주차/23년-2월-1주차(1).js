/*
lv1 음양 더하기
*/
function solution(absolutes, signs) {
  var answer = 0;
  absolutes.forEach((e,index)=>{
      if(signs[index]){
          answer+=e
      }else{
          answer+=(-e)
      }
  })
  return answer;
}