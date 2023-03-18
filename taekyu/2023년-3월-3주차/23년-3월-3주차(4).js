/*
  Lv1 기사단원의 무기
*/
function solution(number, limit, power) {
  var answer = 0
  let result = []
  for (let i = 1; i <= number; i++) {
    let arr = []
    for (let j = 1; j <= i / 2; j++) {
      if (i % j === 0) arr.push(j)
    }
    result.push([...arr, i].length)
  }
  result = result.map((d) => (d > limit ? power : d))
  answer = result.reduce((a, b) => a + b)
  return answer
}
