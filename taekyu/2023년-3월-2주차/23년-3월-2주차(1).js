/*
lv1 정수 제곱근 판별
*/
function solution(n) {
  return Math.sqrt(n) % 1 == 0 ? Math.pow(Math.sqrt(n) + 1, 2) : -1
}
