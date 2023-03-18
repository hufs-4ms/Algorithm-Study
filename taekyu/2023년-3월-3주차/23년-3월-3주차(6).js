/*
  Lv1 카드 뭉치
*/
function solution(cards1, cards2, goal) {
  var answer = 'Yes'
  let arr = []

  const a = goal.filter((d) => cards1.includes(d))
  const b = goal.filter((d) => cards2.includes(d))

  console.log(a)
  console.log(b)

  a.forEach((d, i) => {
    if (d !== cards1[i]) answer = 'No'
  })
  b.forEach((d, i) => {
    if (d !== cards2[i]) answer = 'No'
  })

  return answer
}
