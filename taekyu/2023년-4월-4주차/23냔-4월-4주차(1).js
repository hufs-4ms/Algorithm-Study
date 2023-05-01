/*
lv2 H-Index
*/
function solution(citations) {
  //1:01
  var answer = 0
  citations.sort((a, b) => b - a)
  let cnt = 0

  for (let i = 0; i < citations.length; i++) {
    if (citations[i] <= i) {
      answer = i
      return answer
    }
  }
  return citations.length
}
