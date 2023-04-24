/*
lv2 예상 대진표
*/
function solution(n, a, b) {
  //1:58
  var answer = 1

  let arr = Array(n).fill(0)
  arr[a - 1] = 1
  arr[b - 1] = 1

  while (true) {
    let q = []
    for (let i = 0; i < arr.length; i += 2) {
      q.push(arr[i] + arr[i + 1])
    }
    if (q.includes(2)) {
      break
    }
    arr = q
    answer++
  }

  return answer
}
