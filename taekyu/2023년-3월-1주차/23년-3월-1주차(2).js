/*
Lv1 1차 다트게임
*/
function solution(dartResult) {
  var answer = 0
  let arr = []
  dartResult.split('').forEach((d) => {
    if (arr[arr.length - 1] === '1' && d === '0') {
      arr.pop()
      arr.push(10)
    } else {
      arr.push(d)
    }
  })
  let tmp = 0
  let a = []
  arr.forEach((d) => {
    if (!isNaN(d)) {
      tmp = Number(d)
    } else {
      if (d === 'S') {
        a.push(tmp)
      }
      if (d === 'D') {
        tmp = tmp * tmp
        a.push(tmp)
      }
      if (d === 'T') {
        tmp = tmp * tmp * tmp
        a.push(tmp)
      }
      if (d === '*') {
        let cur = a.pop() * 2
        let pre = a.pop() * 2
        if (!isNaN(pre)) {
          a.push(pre)
        }
        if (!isNaN(cur)) {
          a.push(cur)
        }
      }
      if (d === '#') {
        a.push(a.pop() * -1)
      }
      tmp = 0
      console.log(a)
    }
  })
  answer = a.reduce((a, b) => a + b)
  return answer
}
