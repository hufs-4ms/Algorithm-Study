/*
lv1 푸드 파이터 대회
*/
function solution(food) {
  var answer = ''
  let arr = []
  for (let i = 1; i < food.length; i++) {
    arr.push(Math.floor(food[i] / 2))
  }
  let arr1 = arr.map((d, index) => String(index + 1).repeat(d))
  answer = arr1.join('') + '0' + arr1.reverse().join('')
  return answer
}
