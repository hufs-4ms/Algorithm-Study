/*
lv2 JadenCase 문자열 만들기
*/
function solution(s) {
  var answer = ''
  let arr = []

  s.split(' ').forEach((d) => {
    if (d !== '') {
      d = d[0].toUpperCase() + d.slice(1, d.length).toLowerCase()
    }
    arr.push(d)
  })

  answer = arr.join(' ')
  return answer
}
