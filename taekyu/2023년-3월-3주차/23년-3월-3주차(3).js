/*
  Lv1 숫자 짝꿍
*/

function solution(X, Y) {
  var answer = ''

  let x = X.split('')
  let y = Y.split('')

  for (let i = 0; i < 10; i++) {
    let a = x.filter((d) => Number(d) === i).length
    let b = y.filter((d) => Number(d) === i).length
    answer += String(i).repeat(Math.min(a, b))
  }

  if (answer === '') {
    answer = '-1'
  }
  if (Number(answer) === 0) {
    answer = '0'
  }
  answer = answer
    .split('')
    .sort((a, b) => Number(b) - Number(a))
    .join('')
  return answer
}
