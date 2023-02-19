/*
lv1 두 개 뽑아서 더하기
*/
function solution(numbers) {
  var answer = []
  let arr = []
  for (let i = 0; i < numbers.length; i++) {
    for (let j = i + 1; j < numbers.length; j++) {
      arr.push(numbers[i] + numbers[j])
    }
  }
  answer = [...new Set(arr)].sort((a, b) => a - b)
  return answer
}
