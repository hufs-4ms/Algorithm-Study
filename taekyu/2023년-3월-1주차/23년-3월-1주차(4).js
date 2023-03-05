/*
Lv1 명예의 전당(1)
*/
function solution(k, score) {
  var answer = []
  let stack = []
  let arr = []
  for (let i = 0; i < score.length; i++) {
    stack.push(score[i])
    stack.sort(function (a, b) {
      return b - a
    })
    if (stack.length >= k) {
      arr.push(stack[k - 1])
    } else {
      arr.push(stack[stack.length - 1])
    }
  }
  answer = arr
  return answer
}
