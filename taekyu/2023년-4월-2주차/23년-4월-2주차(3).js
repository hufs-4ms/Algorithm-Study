/*
lv2 짝지어 제거하기
*/
function solution(s) {
  //2:01
  let stack = []

  for (let i of s) {
    if (stack[stack.length - 1] === i) {
      stack.pop()
    } else {
      stack.push(i)
    }
  }

  answer = stack.length === 0 ? 1 : 0

  return answer
}
