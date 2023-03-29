/*
lv1 햄버거 만들기 
*/
function solution(ingredient) {
  var answer = 0
  let stack = []

  const eaqul = (a, b) => {
    let cnt = 0
    for (let i = 0; i < 4; i++) {
      if (a[i] === b[i]) cnt++
    }
    if (cnt === 4) return true
    return false
  }

  for (i of ingredient) {
    stack.push(i)
    if (stack.length >= 4) {
      if (eaqul(stack.slice(stack.length - 4, stack.length), [1, 2, 3, 1])) {
        stack.pop()
        stack.pop()
        stack.pop()
        stack.pop()
        answer++
      }
    }
  }
  return answer
}
