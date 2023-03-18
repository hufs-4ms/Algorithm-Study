/*
  Lv1 체육복
*/
function solution(n, lost, reserve) {
  var answer = 0

  let lost1 = lost.filter((e) => !reserve.includes(e))
  let reserve1 = reserve.filter((e) => !lost.includes(e))

  reserve1.sort((a, b) => a - b)

  reserve1.forEach((e) => {
    if (lost1.includes(e - 1)) {
      lost1 = lost1.filter((d) => d !== e - 1)
    } else if (lost1.includes(e + 1)) {
      lost1 = lost1.filter((d) => d !== e + 1)
    }
  })

  answer = n - lost1.length

  return answer
}
