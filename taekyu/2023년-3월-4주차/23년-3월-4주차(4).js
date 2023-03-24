/*
lv1 문자열 나누기
*/
function solution(s) {
  var answer = 0
  let tmp = ''
  let cnt1 = 0
  let cnt2 = 0
  for (let c of s) {
    if (!tmp) {
      tmp = c
      cnt1++
      continue
    }

    if (tmp === c) {
      cnt1++
    } else {
      cnt2++
    }

    if (cnt1 === cnt2) {
      answer++
      cnt1 = 0
      cnt2 = 0
      tmp = ''
    }
  }
  if (tmp) {
    answer++
  }

  return answer
}
