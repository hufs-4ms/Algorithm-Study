/*
 lv1 가장 가까운 같은 글자
*/
function solution(s) {
  var answer = []
  let arr = []
  s.split('').forEach((d) => {
    if (!arr.includes(d)) {
      arr.push(d)
      answer.push(-1)
    } else {
      answer.push(arr.length - arr.lastIndexOf(d))
      arr.push(d)
    }
  })
  return answer
}
