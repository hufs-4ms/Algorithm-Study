/*
lv2 연속 부분 수열 합의 개수

*/
function solution(elements) {
  var answer = 0
  let len = elements.length
  let n = 1
  let arr = []
  elements = [...elements, ...elements.slice(0, len - 2)]
  while (n <= len) {
    for (let i = 0; i < len; i++) {
      arr.push(elements.slice(i, n + i).reduce((a, b) => a + b))
    }
    n++
  }
  arr = [...new Set(arr)]
  arr.sort((a, b) => a - b)
  answer = arr.length
  return answer
}
