/*
lv2 오픈채팅방
*/
function solution(record) {
  var answer = []
  let dict = {}
  for (let str of record) {
    let [action, id, name] = str.split(' ')
    if (name) {
      dict[id] = name
    }
  }

  for (let str of record) {
    let [action, id, name] = str.split(' ')
    if (action == 'Enter') answer.push(`${dict[id]}님이 들어왔습니다.`)
    else if (action == 'Leave') answer.push(`${dict[id]}님이 나갔습니다.`)
  }
  return answer
}
