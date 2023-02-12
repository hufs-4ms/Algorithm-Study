/*
lv1 서울에서 김서방 찾기
*/
function solution(seoul) {
  var answer = ''
  seoul.forEach((e, index) => {
    if (e == 'Kim') answer = index
  })
  answer = `김서방은 ${answer}에 있다`
  return answer
}
