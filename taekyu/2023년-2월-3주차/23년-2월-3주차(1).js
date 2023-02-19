/*
lv1 최소직사각형 
*/

function solution(sizes) {
  var answer = 0
  const a = sizes.map((d) => (d[0] < d[1] ? [d[1], d[0]] : [d[0], d[1]]))
  answer = Math.max(...a.map((d) => d[0])) * Math.max(...a.map((d) => d[1]))
  return answer
}
