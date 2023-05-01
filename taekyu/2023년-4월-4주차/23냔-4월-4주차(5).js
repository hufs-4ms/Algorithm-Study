/*
lv2 튜플
*/
function solution(s) {
  var answer = []
  let arr = s
    .replaceAll('{', '')
    .split('}')
    .map((d) => d.split(','))
    .map((d) => d.filter((e) => e != ''))
  let que = []
  arr.sort((a, b) => a.length - b.length)
  for (let i of arr) {
    if (i.length == 0) continue

    for (let j of i) {
      j = Number(j)
      if (!que.includes(j)) {
        que.push(j)
      }
    }
  }
  answer = que
  return answer
}
