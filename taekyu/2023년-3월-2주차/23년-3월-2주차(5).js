/*
lv1 내적
*/
function solution(a, b) {
  return a.reduce((d, _, i) => (d += a[i] * b[i]), 0)
}
