/*
lv1 개인정보 수집 유효기간
*/
function solution(today, terms, privacies) {
  //12:34
  var answer = []
  const dict = {}
  const [ty, tm, td] = today.split('.').map(Number)
  for (let i of terms) {
    const [t1, t2] = i.split(' ')
    dict[t1] = t2
  }

  let cnt = 1
  for (let i of privacies) {
    const [day, term] = i.split(' ')
    let [y, m, d] = day.split('.')

    y = Number(y)
    m = Number(dict[term]) + Number(m)
    d = Number(d) - 1

    if (m > 12) {
      if (m % 12 === 0) {
        y = y + Math.floor(m / 12) - 1
        m = 12
      } else {
        y = y + Math.floor(m / 12)
        m = m % 12
      }
    }

    if (d === 0) {
      m = m - 1
      if (m === 0) {
        y = y - 1
        m = 12
      }
      d = 28
    }

    if (y < ty) {
      answer.push(cnt)
    } else if (y === ty) {
      if (m < tm) {
        answer.push(cnt)
      } else if (m === tm) {
        if (d < td) {
          answer.push(cnt)
        }
      }
    }
    cnt++
  }

  return answer
}
