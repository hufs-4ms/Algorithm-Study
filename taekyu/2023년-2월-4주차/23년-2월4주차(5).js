/*
 lv1 모의고사
*/
function solution(answers) {
  var answer = []

  const a1 = '12345'
  const a2 = '21232425'
  const a3 = '3311224455'
  const arr = Array(3).fill(0)
  for (let i = 0; i < answers.length; i++) {
    if (a1[i % 5] == answers[i]) {
      arr[0]++
    }
    if (a2[i % 8] == answers[i]) {
      arr[1]++
    }
    if (a3[i % 10] == answers[i]) {
      arr[2]++
    }
  }
  for (let i = 0; i < arr.length; i++) {
    if (Math.max(...arr) == arr[i]) {
      answer.push(i + 1)
    }
  }
  if (answer.lenght > 1) {
    answer.sort(function (a, b) {
      return a - b
    })
  }

  return answer
}
