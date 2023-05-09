/*
lv2 기능개발
*/
function solution(progresses, speeds) {
  var answer = []
  let tasks = []
  for (let i = 0; i < speeds.length; i++) {
    let a = Math.floor((100 - progresses[i]) / speeds[i])
    let b = Math.floor((100 - progresses[i]) % speeds[i]) ? 1 : 0
    let task = a + b
    tasks.push(task)
  }
  let tmp = tasks.shift()
  let cnt = 1
  for (let i of tasks) {
    if (tmp >= i) {
      cnt++
    } else {
      tmp = i
      answer.push(cnt)
      cnt = 1
    }
  }
  answer.push(cnt)
  return answer
}
