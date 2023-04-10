/*
lv2 올바른 괄호
*/
function solution(s) {
  var answer = true
  let stack = []

  s.split('').forEach((d) => {
    if (d === ')') {
      if (stack[stack.length - 1] === '(') {
        stack.pop()
      } else {
        stack.push(d)
      }
    } else {
      stack.push(d)
    }
  })
  if (stack.length !== 0) answer = false
  return answer
}
