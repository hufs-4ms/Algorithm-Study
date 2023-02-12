/*
lv1 문자열 내 p와 y의 개수
*/
function solution(s) {
  var answer = true
  const p = s.split('').filter((d) => d.toLowerCase() == 'p').length
  const y = s.split('').filter((d) => d.toLowerCase() == 'y').length

  if (p != y) {
    answer = false
  }

  return answer
}
