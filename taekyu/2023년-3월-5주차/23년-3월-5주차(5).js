/*
lv1 둘만의 암호
*/
function solution(s, skip, index) {
  //5:30
  var answer = ''

  let alpha = [
    'a',
    'b',
    'c',
    'd',
    'e',
    'f',
    'g',
    'h',
    'i',
    'j',
    'k',
    'l',
    'm',
    'n',
    'o',
    'p',
    'q',
    'r',
    's',
    't',
    'u',
    'v',
    'w',
    'x',
    'y',
    'z',
  ]

  alpha = alpha.filter((d) => !skip.split('').includes(d))
  for (let i = 0; i < s.length; i++) {
    let tmp = alpha.indexOf(s[i]) + index

    if (alpha.length <= tmp) {
      tmp = tmp % alpha.length
    }
    answer += alpha[tmp]
  }

  return answer
}
