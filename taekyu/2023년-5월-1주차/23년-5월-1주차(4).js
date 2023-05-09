/*
lv2 할인 행사
*/
function solution(want, number, discount) {
  var answer = 0
  let len = number.reduce((a, b) => a + b)
  let idx = 0

  while (len <= discount.length) {
    let arr = discount.slice(idx, len)
    let sum = 0
    for (let i = 0; i < number.length; i++) {
      if (arr.filter((d) => d == want[i]).length == number[i]) sum++
    }
    if (sum == number.length) answer++

    idx++
    len++
  }

  return answer
}
