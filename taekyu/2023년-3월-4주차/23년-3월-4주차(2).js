/*
lv1 키패드 누르기
*/
function solution(numbers, hand) {
  var answer = ''
  let pos = [
    [3, 1],
    [0, 0],
    [0, 1],
    [0, 2],
    [1, 0],
    [1, 1],
    [1, 2],
    [2, 0],
    [2, 1],
    [2, 2],
  ]
  let Lpos = [3, 0]
  let Rpos = [3, 2]
  let arr = []
  numbers.forEach((num) => {
    if ([1, 4, 7].includes(num)) {
      Lpos = [pos[num][0], pos[num][1]]
      arr.push('L')
    }
    if ([3, 6, 9].includes(num)) {
      Rpos = [pos[num][0], pos[num][1]]
      arr.push('R')
    }
    if ([2, 5, 8, 0].includes(num)) {
      let Ldis =
        Math.abs(Lpos[0] - pos[num][0]) + Math.abs(Lpos[1] - pos[num][1])
      let Rdis =
        Math.abs(Rpos[0] - pos[num][0]) + Math.abs(Rpos[1] - pos[num][1])
      if (Ldis > Rdis) {
        Rpos = [pos[num][0], pos[num][1]]
        arr.push('R')
      } else if (Ldis < Rdis) {
        Lpos = [pos[num][0], pos[num][1]]
        arr.push('L')
      } else {
        if (hand === 'right') {
          Rpos = [pos[num][0], pos[num][1]]
          arr.push('R')
        } else {
          Lpos = [pos[num][0], pos[num][1]]
          arr.push('L')
        }
      }
    }
  })
  answer = arr.join('')
  return answer
}
