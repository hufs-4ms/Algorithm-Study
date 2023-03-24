/*
lv1 옹알이(2)
*/
function solution(babbling) {
  var answer = 0

  let arr = ['aya', 'ye', 'woo', 'ma']
  // babbling을 차례대로 검사함
  // 앞에 글자가 같고 두번 중복 안되는지 검사 맞으면 ''로 교체
  babbling.forEach((d) => {
    for (let i = 0; i < arr.length; i++) {
      if (d.includes(arr[i].repeat(2))) {
        break
      }
      d = d.split(arr[i]).join(' ')
    }
    if (!d.split(' ').join('').length) {
      answer++
    }
  })

  return answer
}
