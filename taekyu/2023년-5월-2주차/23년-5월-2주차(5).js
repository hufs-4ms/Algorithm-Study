/*
lv2 땅따먹기
*/
function solution(land) {
  //9:13
  var answer = 0
  let arr = []

  for (let i = 1; i < land.length; i++) {
    for (let j = 0; j < 4; j++) {
      land[i][j] += Math.max(...land[i - 1].filter((_, idx) => idx != j))
    }
  }
  answer = Math.max(...land[land.length - 1])
  return answer
}
