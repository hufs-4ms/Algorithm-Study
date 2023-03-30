/*
lv1 대충 만든 자판
*/
function solution(keymap, targets) {
  var answer = []

  for (let i = 0; i < targets.length; i++) {
    let target = targets[i]
    let num = 0
    for (let e of target) {
      let arr = []
      for (let setence of keymap) {
        arr.push(setence.indexOf(e))
      }
      arr = arr.filter((d) => d !== -1)
      if (arr.length === 0) {
        num = -1
        break
      }
      num += Math.min(...arr) + 1
    }
    answer.push(num)
  }

  return answer
}
