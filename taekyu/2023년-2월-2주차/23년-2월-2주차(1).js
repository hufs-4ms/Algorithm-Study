/*
lv1 이상한 문자 만들기
*/
function solution(s) {
  var answer = ''
  let arr = []
  s.split(' ').forEach((e) => {
    let str = ''
    e.split('').forEach((d, index) => {
      if (index % 2 == 0) {
        str += d.toUpperCase()
      } else {
        str += d.toLowerCase()
      }
    })
    arr.push(str)
  })
  answer = arr.join(' ')
  return answer
}
