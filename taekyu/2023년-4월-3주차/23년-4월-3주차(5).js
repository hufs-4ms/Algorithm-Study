/*
lv2 귤 고르기
*/
function solution(k, tangerine) {
  let obj = {}
  for (let i of tangerine) {
    obj[i] = ++obj[i] || 1
  }

  tangerine = Object.values(obj).sort((a, b) => b - a)
  let sum = 0
  for (let i = 0; i < tangerine.length; i++) {
    sum += tangerine[i]
    if (sum >= k) {
      return i ? i + 1 : 1
    }
  }
}
