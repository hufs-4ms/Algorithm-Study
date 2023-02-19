/*
lv1 크기가 작은 부분 문자열
*/
function solution(t, p) {
  var answer = 0
  const len = p.length
  for (let i = 0; i < t.length - len + 1; i++) {
    if (Number(t.slice(0 + i, len + i)) <= Number(p)) {
      answer++
    }
  }
  return answer
}
