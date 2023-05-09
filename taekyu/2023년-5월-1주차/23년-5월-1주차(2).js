/*
lv2 프로세스
*/
function solution(priorities, location) {
  //10:02
  var answer = 0
  let arr = []

  let que = Array.from({ length: priorities.length }, (v, i) => i)
  let a = 0
  while (priorities.length) {
    let process = priorities.shift()
    let tmp = que.shift()

    let prioty = priorities.filter((d) => process < d)

    if (!prioty.length) {
      arr.push(tmp)
    } else {
      priorities.push(process)
      que.push(tmp)
    }
  }
  answer = arr.findIndex((e) => e == location)
  return answer + 1
}
