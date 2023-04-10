/*
lv2 이진 변환 반복하기
*/
function solution(s) {
  var answer = []
  let num = '0'
  let cnt = 0
  let cnt2 = 0
  let cnt3 = 0
  while (s !== '1') {
    for (i of s) {
      if (i === '0') {
        cnt++
      } else {
        cnt2++
      }
    }
    s = cnt2.toString(2)
    cnt2 = 0
    cnt3++
  }
  answer = [cnt3, cnt]
  return answer
}
