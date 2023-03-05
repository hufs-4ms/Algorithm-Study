/*
Lv1 실패율
*/
function solution(N, stages) {
  var answer = []
  let arr = []
  let len = stages.length

  for (let i = 1; i <= N; i++) {
    arr.push([i, stages.filter((d) => d == i).length / len])
    len -= stages.filter((d) => d == i).length
  }
  answer = arr
    .sort(function (a, b) {
      return b[1] - a[1]
    })
    .map((d) => d[0])
  return answer
}
