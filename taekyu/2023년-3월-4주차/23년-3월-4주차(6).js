/*
lv1 성격 유형 검사하기
*/
function solution(survey, choices) {
  var answer = ''
  let s = [3, 2, 1, 0, 1, 2, 3]
  let arr = []
  let p = {
    R: 0,
    T: 0,
    C: 0,
    F: 0,
    J: 0,
    M: 0,
    A: 0,
    N: 0,
  }
  choices.forEach((d, index) => {
    if (d < 4) {
      p[survey[index][0]] = p[survey[index][0]] + s[d - 1]
    } else if (d > 4) {
      p[survey[index][1]] = p[survey[index][1]] + s[d - 1]
    }
  })

  p['R'] >= p['T'] ? arr.push('R') : arr.push('T')
  p['C'] >= p['F'] ? arr.push('C') : arr.push('F')
  p['J'] >= p['M'] ? arr.push('J') : arr.push('M')
  p['A'] >= p['N'] ? arr.push('A') : arr.push('N')

  answer = arr.join('')

  return answer
}
