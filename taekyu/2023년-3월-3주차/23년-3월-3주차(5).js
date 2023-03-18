/*
  Lv1 완주하지 못한 선수
*/
function solution(participant, completion) {
  var answer = ''
  let arr = []

  participant.sort()
  completion.sort()

  for (let i = 0; i < participant.length; i++) {
    if (participant[i] != completion[i]) {
      answer = participant[i]
      break
    }
  }

  return answer
}
