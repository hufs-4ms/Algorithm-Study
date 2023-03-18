/*
  Lv1 로또의 최고 순위와 최저 순위
*/
function solution(lottos, win_nums) {
  var answer = []
  let cnt = 0
  let cnt1 = 0
  lottos.forEach((d) => {
    if (win_nums.includes(d)) {
      cnt++
      win_nums.splice(win_nums.indexOf(d), 1)
    }
    if (d === 0) {
      cnt1++
    }
  })
  answer = [win(cnt + cnt1), win(cnt)]
  return answer
}
function win(d) {
  switch (d) {
    case 6:
      return 1
    case 5:
      return 2
    case 4:
      return 3
    case 3:
      return 4
    case 2:
      return 5
    default:
      return 6
  }
}
