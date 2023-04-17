/*
lv2 다음 큰 숫자
*/
function solution(n) {
  //12:20
  var answer = 0

  let preCount = n
    .toString(2)
    .split('')
    .filter((d) => d === '1').length
  let curCount = 0
  while (preCount !== curCount) {
    n++
    curCount = n
      .toString(2)
      .split('')
      .filter((d) => d === '1').length
  }
  answer = n

  return answer
}
