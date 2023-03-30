/*
lv1 신고 결과 받기
*/
function solution(id_list, report, k) {
  var answer = []
  let dict = {}
  let user = {}
  for (let i of id_list) {
    dict[i] = 0
    user[i] = []
  }

  for (let i of report) {
    const [a, b] = i.split(' ')
    if (!user[a].includes(b)) {
      dict[b] = dict[b] + 1
      user[a].push(b)
    }
  }

  let arr = []
  for (let i in dict) {
    if (dict[i] >= k) {
      arr.push(i)
    }
  }

  for (let i in user) {
    user[i] = user[i].filter((d) => arr.includes(d))
  }

  for (let i in user) {
    answer.push(user[i].length)
  }
  return answer
}
