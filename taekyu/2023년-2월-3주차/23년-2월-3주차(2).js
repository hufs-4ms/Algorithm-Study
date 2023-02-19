/*
lv1 문자열 내 마음대로 정렬하기
*/

function solution(strings, n) {
  var answer = []
  strings.sort()

  strings.sort(function (a, b) {
    if (a[n] < b[n]) return -1
    if (a[n] > b[n]) return 1
    if (a[n] === b[n]) return 0
  })
  answer = strings
  return answer
}
