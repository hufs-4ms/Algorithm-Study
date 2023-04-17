/*
lv2 구명보트
*/
function solution(people, limit) {
  //4:53
  var answer = 0
  people.sort((a, b) => a - b)
  let l = 0
  let r = people.length - 1

  while (l < r) {
    if (people[l] + people[r] > limit) {
      r--
    } else {
      l++
      r--
    }
    answer++
  }
  if (l == r) answer++

  return answer
}
