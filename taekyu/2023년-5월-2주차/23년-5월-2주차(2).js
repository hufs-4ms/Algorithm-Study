/*
lv2 [3차] n진수 게임
*/
function solution(n, t, m, p) {
  //11:16
  var answer = ''
  let cnt = 0

  let dict = {}
  for (let i = 0; i < m; i++) {
    dict[i] = ''
  }
  let tmp = 0

  while (dict[p - 1].length < t) {
    let s = cnt.toString(n)
    for (let i = 0; i < s.length; i++) {
      dict[tmp++ % m] += s[i].toUpperCase()
    }
    cnt++
  }

  answer = dict[p - 1].slice(0, t)
  return answer
}
