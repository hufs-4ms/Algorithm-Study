/*
lv2 n^2 배열 자르기
*/
function solution(n, left, right) {
  var answer = []

  for (let i = left; i <= right; i++) {
    answer.push(Math.max(i % n, parseInt(i / n)) + 1)
  }
  return answer
}
