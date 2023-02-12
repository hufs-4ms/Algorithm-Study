/*
lv1 시저암호
*/
function solution(s, n) {
  var answer = ''
  let up = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
  let low = 'abcdefghijklmnopqrstuvwxyz'
  s.split('').forEach((d) => {
    let tmp = ' '
    if (d.toUpperCase() === d && d != ' ') {
      tmp = up[(up.indexOf(d) + n) % 26]
    }
    if (d.toLowerCase() === d && d != ' ') {
      tmp = low[(low.indexOf(d) + n) % 26]
    }
    answer += tmp
  })
  return answer
}
