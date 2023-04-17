/*
lv2 영어 끝말잇기
*/
function solution(n, words) {
  //2:17
  var answer = [0, 0]

  for (let i = 0; i < words.length; i++) {
    let a = (i % n) + 1
    let b = Math.ceil((i + 1) / n)
    if (i > 0) {
      let first = words[i - 1].split('').pop()
      let last = words[i][0]

      if (first !== last) {
        answer = [a, b]
        break
      } else if (i > words.indexOf(words[i])) {
        answer = [a, b]
        break
      }
    }
  }

  return answer
}
