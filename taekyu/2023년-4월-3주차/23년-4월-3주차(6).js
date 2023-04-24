/*
lv2 괄호 회전하기
*/
function solution(s) {
  var answer = 0
  let isTure = true
  let stack = []
  if (s.length % 2 === 1) return 0

  for (let i = 0; i < s.length; i++) {
    let str = s.slice(i) + s.slice(0, i)
    isTure = true
    for (let w of str) {
      if (w === '(' || w === '{' || w === '[') {
        stack.push(w)
      } else {
        let c = stack.pop()
        let word = c + w
        if (word === '()') continue
        if (word === '{}') continue
        if (word === '[]') continue
        isTure = false
        break
      }
    }
    if (isTure) answer++
  }

  return answer
}
