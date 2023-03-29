/*
Lv2 위장
*/
// String 기반으로 정보를 기록하고 관리할때 해시를 사용
// 옷의 종류(str) : value(int)
function solution(clothes) {
  var answer = 1
  let dict = {}
  for (let arr of clothes) {
    if (Object.keys(dict).includes(arr[1])) {
      dict[arr[1]] = dict[arr[1]] + 1
    } else {
      dict[arr[1]] = 1
    }
  }

  Object.values(dict).forEach((n) => {
    answer *= n + 1
  })

  return answer - 1
}
