/*
Lv1 과일장수
*/
function solution(k, m, score) {
  // 최저 사과 점수 * 한 상자의 담긴 사과 개수 * 상자 개수
  var answer = 0
  let arr = []
  let a = []
  score
    .sort(function (a, b) {
      return b - a
    })
    .forEach((d) => {
      arr.push(d)
      if (arr.length === m) {
        answer += Math.min(...arr) * m
        arr = []
      }
    })
  return answer
}
