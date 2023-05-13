/*
lv2 [3차] 압축
*/
function solution(msg) {
  //4:02
  var answer = []
  const alpha = [
    'A',
    'B',
    'C',
    'D',
    'E',
    'F',
    'G',
    'H',
    'I',
    'J',
    'K',
    'L',
    'M',
    'N',
    'O',
    'P',
    'Q',
    'R',
    'S',
    'T',
    'U',
    'V',
    'W',
    'X',
    'Y',
    'Z',
  ]
  let cnt = 1
  let dict = {}
  for (let i of alpha) {
    dict[i] = cnt++
  }

  while (msg) {
    for (let i = msg.length; i >= 0; i--) {
      let w = msg.slice(0, i)
      let wc = msg.slice(0, i + 1)

      if (dict[w]) {
        answer.push(dict[w])
        msg = msg.slice(i, msg.length)
        dict[wc] = cnt++
        break
      }
    }
  }
  return answer
}
