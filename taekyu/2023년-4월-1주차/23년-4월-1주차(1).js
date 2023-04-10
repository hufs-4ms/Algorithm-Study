/*
lv2 최대값과 최솟값
*/
function solution(s) {
  var answer = ''

  let arr = s.split(' ').map(Number)

  answer = `${Math.min(...arr)} ${Math.max(...arr)}`

  return answer
}
