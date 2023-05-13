/*
lv2 주차 요금 계산
*/
function solution(fees, records) {
  var answer = []
  let arr = []
  let carNum = []

  for (let i of records) {
    let tmp = i.split(' ')
    arr.push(tmp)
    carNum.push(tmp[1])
  }
  carNum = [...new Set(carNum)].sort((a, b) => a - b)
  for (let i of carNum) {
    let num = arr.filter((d) => d[1] === i)
    let stack = []
    for (let j of num) {
      stack.push(j[0])
    }
    if (stack.length % 2 == 1) stack.push('23:59') //값이 홀수면 마지막 출차시간이 없으니까 23:59추가

    let time = 0

    while (stack.length) {
      let prev2 = stack.pop().split(':').map(Number)
      let prev1 = stack.pop().split(':').map(Number)
      if (prev2[1] - prev1[1] < 0) {
        time += (prev2[0] - 1 - prev1[0]) * 60 + (60 + prev2[1] - prev1[1])
      } else {
        time += (prev2[0] - prev1[0]) * 60 + (prev2[1] - prev1[1])
      }
    }
    let money = 0
    if (time <= fees[0]) {
      money = fees[1]
    } else {
      money = fees[1] + Math.ceil((time - fees[0]) / fees[2]) * fees[3]
    }
    answer.push(money)
  }

  return answer
}
