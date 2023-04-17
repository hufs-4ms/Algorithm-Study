/*
lv2 카펫
*/
function solution(brown, yellow) {
  //4:18
  var answer = []

  for (let i = 3; i < brown + yellow; i++) {
    let j = Math.floor((brown + yellow) / i)
    if ((i - 2) * (j - 2) === yellow) {
      answer = [i, j]
    }
  }

  return answer
}
